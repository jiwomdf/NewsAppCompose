package com.katilijiwoadiwiyono.core.data.repository

import com.katilijiwoadiwiyono.core.common.BaseRepository
import com.katilijiwoadiwiyono.core.data.remote.source.RemoteDataSource
import com.katilijiwoadiwiyono.core.domain.model.NewsModel
import com.katilijiwoadiwiyono.core.utils.ApiResponse
import com.katilijiwoadiwiyono.core.utils.Resource

class NewsRepositoryImpl constructor(
    private val remote: RemoteDataSource,
): BaseRepository(), NewsRepository {
    override suspend fun getNews(): Resource<List<NewsModel>> {
        val result = mapResponse(remote.getNews()) {
            NewsModel.mapNewsModel(it)
        }
        return result
    }
}