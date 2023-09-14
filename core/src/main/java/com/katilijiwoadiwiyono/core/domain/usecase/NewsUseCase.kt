package com.katilijiwoadiwiyono.core.domain.usecase

import com.katilijiwoadiwiyono.core.data.remote.response.news.NewsResponse
import com.katilijiwoadiwiyono.core.domain.model.NewsModel

interface NewsUseCase {
    suspend fun getNews(): List<NewsModel>
    suspend fun getNewsDetail(id: Int): NewsModel?
}