package com.katilijiwoadiwiyono.core.data.remote.source

import com.katilijiwoadiwiyono.core.data.remote.response.news.NewsResponse
import com.katilijiwoadiwiyono.core.data.remote.network.NewsApi
import com.katilijiwoadiwiyono.core.data.remote.network.HttpRoutes
import io.ktor.client.request.get

class RemoteDataSourceImpl(newsApi: NewsApi): RemoteDataSource {

    private val httpClient = newsApi.httpClient

    override suspend fun getNews(): List<NewsResponse> {
        return httpClient.get(HttpRoutes.GET_NEWS_COLLECTIONS)
    }

}