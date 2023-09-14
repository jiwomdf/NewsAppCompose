package com.katilijiwoadiwiyono.core.utils

import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.get
import io.ktor.utils.io.errors.IOException

suspend inline fun <reified T,> HttpClient.safeRequest(
    block: String,
): ApiResponse<T> =
    try {
        val response = get<T>(block)
        ApiResponse.Success(response)
    } catch (ex: ClientRequestException) {
        ApiResponse.Error.HttpClientError(ex)
    } catch (ex: ServerResponseException) {
        ApiResponse.Error.HttpServerError(ex)
    } catch (ex: IOException) {
        ApiResponse.Error.NetworkError(ex)
    } catch (ex: Exception) {
        ApiResponse.Error.UnknownError(ex)
    }
