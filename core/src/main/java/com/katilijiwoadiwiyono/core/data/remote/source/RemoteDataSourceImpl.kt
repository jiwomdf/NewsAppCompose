package com.katilijiwoadiwiyono.core.data.remote.source

import com.katilijiwoadiwiyono.core.data.remote.network.HttpRoutes
import com.katilijiwoadiwiyono.core.data.remote.network.NewsApi
import com.katilijiwoadiwiyono.core.data.remote.response.news.NewsResponse
import com.katilijiwoadiwiyono.core.utils.ApiResponse
import com.katilijiwoadiwiyono.core.utils.safeRequest

class RemoteDataSourceImpl(newsApi: NewsApi): RemoteDataSource {

    private val httpClient = newsApi.httpClient

    override suspend fun getNews(): ApiResponse<List<NewsResponse>> {
        return httpClient.safeRequest(HttpRoutes.GET_NEWS_COLLECTIONS)
    }

}