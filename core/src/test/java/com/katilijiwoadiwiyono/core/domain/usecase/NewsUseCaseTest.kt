package com.katilijiwoadiwiyono.core.domain.usecase

import com.katilijiwoadiwiyono.core.util.newsModel
import com.katilijiwoadiwiyono.core.data.repository.NewsRepository
import com.katilijiwoadiwiyono.core.domain.model.NewsModel
import com.katilijiwoadiwiyono.core.utils.Resource
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class NewsUseCaseTest {

    private lateinit var useCase: NewsUseCase

    @Mock
    private var repository = Mockito.mock(NewsRepository::class.java)

    @Before
    fun setup() {
        useCase = NewsInteractor(repository)
    }

    @Test
    fun `call getNews, model success`() = runBlocking {
        val response = Resource.Success(newsModel)
        Mockito.`when`(repository.getNews()).thenReturn(response)
        val result = useCase.getNews()
        TestCase.assertEquals(response, result)
    }

    @Test
    fun `call getNews, model error`() = runBlocking {
        val ex = Exception()
        val response = Resource.Error.UnknownError<List<NewsModel>>(ex)
        Mockito.`when`(repository.getNews()).thenReturn(response)
        val result = useCase.getNews()
        TestCase.assertEquals(response, result)
    }


}