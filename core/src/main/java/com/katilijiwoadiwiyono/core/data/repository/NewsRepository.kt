package com.katilijiwoadiwiyono.core.data.repository

import com.katilijiwoadiwiyono.core.data.remote.response.news.NewsResponse
import com.katilijiwoadiwiyono.core.domain.model.NewsModel

interface NewsRepository {
    suspend fun getNews(): List<NewsModel>
}