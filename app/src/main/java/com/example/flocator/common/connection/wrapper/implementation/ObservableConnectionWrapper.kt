package com.example.flocator.common.connection.wrapper.implementation

import androidx.lifecycle.Observer
import com.example.flocator.common.connection.watcher.ConnectionLiveData
import com.example.flocator.common.connection.wrapper.ConnectionWrapper
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.net.ConnectException

class ObservableConnectionWrapper<T : Any>(
    private val observable: Observable<T>,
    private val connectionLiveData: ConnectionLiveData
) : ConnectionWrapper<Observable<T>> {
    override fun connect(): Observable<T> {
        val compositeDisposable = CompositeDisposable()
        var observer: Observer<Boolean>? = null
        return Observable.create { emitter ->
            observer = Observer {
                if (!it) {
                    throw ConnectException("Connection is lost!")
                }
            }
            connectionLiveData.observeForeverAsync(observer!!)
            compositeDisposable.add(
                observable
                    .doOnNext { emitter.onNext(it) }
                    .subscribe()
            )
        }
            .doOnDispose {
                compositeDisposable.dispose()
            }
            .doOnComplete {
                connectionLiveData.removeObserverAsync(observer!!)
            }
    }
}