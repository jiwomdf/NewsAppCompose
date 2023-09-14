package com.katilijiwoadiwiyono.core.data.repository

import com.katilijiwoadiwiyono.core.data.remote.response.news.NewsResponse
import com.katilijiwoadiwiyono.core.domain.model.NewsModel
import com.katilijiwoadiwiyono.core.utils.ApiResponse
import com.katilijiwoadiwiyono.core.utils.Resource

interface NewsRepository {
    suspend fun getNews(): Resource<List<NewsModel>>
}