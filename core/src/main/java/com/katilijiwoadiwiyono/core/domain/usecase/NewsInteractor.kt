package com.katilijiwoadiwiyono.core.domain.usecase

import com.katilijiwoadiwiyono.core.data.repository.NewsRepository
import com.katilijiwoadiwiyono.core.domain.model.NewsModel
import com.katilijiwoadiwiyono.core.utils.Resource

class NewsInteractor constructor(
    private val repository: NewsRepository
): NewsUseCase {
    override suspend fun getNews(): Resource<List<NewsModel>> {
        return repository.getNews()
    }
}