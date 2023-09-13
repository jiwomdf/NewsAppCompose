package com.katilijiwoadiwiyono.core.data.remote.source

import com.katilijiwoadiwiyono.core.data.remote.response.news.NewsResponse
import com.katilijiwoadiwiyono.core.data.remote.network.Api
import com.katilijiwoadiwiyono.core.data.remote.network.HttpRoutes
import io.ktor.client.request.get

class RemoteDataSourceImpl(api: Api): RemoteDataSource {

    private val httpClient = api.httpClient

    override suspend fun getNews(): List<NewsResponse> {
        return httpClient.get(HttpRoutes.GET_NEWS_COLLECTIONS)
    }

}