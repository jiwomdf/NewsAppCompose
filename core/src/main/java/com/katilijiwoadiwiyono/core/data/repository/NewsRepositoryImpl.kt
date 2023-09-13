package com.katilijiwoadiwiyono.core.data.repository

import com.katilijiwoadiwiyono.core.data.remote.response.news.NewsResponse
import com.katilijiwoadiwiyono.core.data.remote.source.RemoteDataSource
import com.katilijiwoadiwiyono.core.domain.model.NewsModel

class NewsRepositoryImpl constructor(
    private val remote: RemoteDataSource,
): NewsRepository {
    override suspend fun getNews(): List<NewsModel> {
        val response = remote.getNews()
        return NewsModel.mapNewsModel(response)
    }
}