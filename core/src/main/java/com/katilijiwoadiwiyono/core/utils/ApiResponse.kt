package com.katilijiwoadiwiyono.core.utils

sealed class ApiResponse<out T> {
    /**
     * Represents successful network responses (2xx).
     */
    data class Success<T>(val body: T) : ApiResponse<T>()

    object Error {
        /**
         * Represents server (50x)  errors.
         */
        data class HttpServerError<Nothing>(val exception: Exception): ApiResponse<Nothing>()

        /**
         * Represents client (40x) errors.
         */
        data class HttpClientError<Nothing>(val exception: Exception): ApiResponse<Nothing>()

        /**
         * Represent IOExceptions and connectivity issues.
         */
        data class NetworkError<Nothing>(val exception: Exception): ApiResponse<Nothing>()

        /**
         * Represent Error unknown.
         */
        data class UnknownError<Nothing>(val exception: Exception): ApiResponse<Nothing>()
    }
}
