package com.katilijiwoadiwiyono.core.common

import com.katilijiwoadiwiyono.core.utils.ApiResponse
import com.katilijiwoadiwiyono.core.utils.Resource

open class BaseRepository {
    fun <T, M> mapResponse(
        data: ApiResponse<T>,
        mapData: (T) -> M
    ): Resource<M> {
        return when(data) {
            is ApiResponse.Success -> {
                Resource.Success(mapData(data.body))
            }
            is ApiResponse.Error.HttpClientError -> {
                Resource.Error.HttpClientError(data.exception)
            }
            is ApiResponse.Error.HttpServerError -> {
                Resource.Error.HttpServerError(data.exception)
            }
            is ApiResponse.Error.NetworkError -> {
                Resource.Error.NetworkError(data.exception)
            }
            is ApiResponse.Error.UnknownError -> {
                Resource.Error.UnknownError(data.exception)
            }
        }
    }
}