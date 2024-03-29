package com.example.flocator.main.ui.mark.data

sealed class MarkFragmentState {
    object Loading: MarkFragmentState()
    object Loaded: MarkFragmentState()
    class Failed(val cause: Throwable): MarkFragmentState()
}