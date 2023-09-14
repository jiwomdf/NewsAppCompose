package com.katilijiwoadiwiyono.core.data.remote.source

import com.katilijiwoadiwiyono.core.data.remote.response.news.NewsResponse
import com.katilijiwoadiwiyono.core.utils.ApiResponse

interface RemoteDataSource {
    suspend fun getNews(): ApiResponse<List<NewsResponse>>
}