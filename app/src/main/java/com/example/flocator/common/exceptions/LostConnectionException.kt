package com.example.flocator.common.exceptions

class LostConnectionException @JvmOverloads constructor(
    message: String = "",
    throwable: Throwable? = null
) : Exception(message, throwable) {
}