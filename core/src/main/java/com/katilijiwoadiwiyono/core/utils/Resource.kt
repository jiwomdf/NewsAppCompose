package com.katilijiwoadiwiyono.core.utils

sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()

    object Error {
        data class HttpServerError<T>(val exception: Exception) : Resource<T>()
        data class HttpClientError<T>(val exception: Exception) : Resource<T>()
        data class NetworkError<T>(val exception: Exception) : Resource<T>()
        data class UnknownError<T>(val exception: Exception) : Resource<T>()
    }
}