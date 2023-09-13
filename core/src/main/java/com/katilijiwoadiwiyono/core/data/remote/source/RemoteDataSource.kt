package com.katilijiwoadiwiyono.core.data.remote.source

import com.katilijiwoadiwiyono.core.data.remote.response.news.NewsResponse

interface RemoteDataSource {
    suspend fun getNews(): List<NewsResponse>
}