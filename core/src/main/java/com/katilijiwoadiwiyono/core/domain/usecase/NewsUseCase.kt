package com.katilijiwoadiwiyono.core.domain.usecase

import com.katilijiwoadiwiyono.core.data.remote.response.news.NewsResponse
import com.katilijiwoadiwiyono.core.domain.model.NewsModel
import com.katilijiwoadiwiyono.core.utils.Resource

interface NewsUseCase {
    suspend fun getNews(): Resource<List<NewsModel>>
}