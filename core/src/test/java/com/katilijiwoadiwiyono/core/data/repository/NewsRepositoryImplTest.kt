package com.katilijiwoadiwiyono.core.data.repository

import com.katilijiwoadiwiyono.core.util.newsResponse
import com.katilijiwoadiwiyono.core.data.remote.response.news.NewsResponse
import com.katilijiwoadiwiyono.core.data.remote.source.RemoteDataSource
import com.katilijiwoadiwiyono.core.domain.model.NewsModel
import com.katilijiwoadiwiyono.core.utils.ApiResponse
import com.katilijiwoadiwiyono.core.utils.Resource
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock


class NewsRepositoryTest {

    private lateinit var repository: NewsRepository

    @Mock
    private var remote = mock(RemoteDataSource::class.java)

    @Before
    fun setup() {
        repository = NewsRepositoryImpl(remote)
    }

    @Test
    fun `call getNews, response success and response mapped to model`() = runBlocking {
        val response = ApiResponse.Success(newsResponse)
        Mockito.`when`(remote.getNews()).thenReturn(response)
        val result = repository.getNews()
        val model = Resource.Success(NewsModel.mapNewsModel(newsResponse))
        assertEquals(model, result)
    }

    @Test
    fun `call getNews, response error and response mapped to model`() = runBlocking {
        val ex = Exception()
        val response = ApiResponse.Error.UnknownError<List<NewsResponse>>(ex)
        Mockito.`when`(remote.getNews()).thenReturn(response)
        val result = repository.getNews()
        val model = Resource.Error.UnknownError<List<NewsResponse>>(ex)
        assertEquals(model, result)
    }
}