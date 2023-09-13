package com.katilijiwoadiwiyono.core.domain.usecase

import com.katilijiwoadiwiyono.core.data.repository.NewsRepository
import com.katilijiwoadiwiyono.core.domain.model.NewsModel

class NewsInteractor constructor(
    private val repository: NewsRepository
): NewsUseCase {
    override suspend fun getNews(): List<NewsModel> {
        return repository.getNews()
    }
}