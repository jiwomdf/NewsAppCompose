package com.katilijiwoadiwiyono.core.data.remote.source

import com.katilijiwoadiwiyono.core.data.remote.network.NewsApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class RemoteDataSourceTest {

    private lateinit var repository: RemoteDataSource

    @Mock
    private var newsApi = Mockito.mock(NewsApi::class.java)

    @Before
    fun setup() {
        repository = RemoteDataSourceImpl(newsApi)
    }

    @Test
    fun `call getNews, response success`() = runBlocking {
//        val response = ApiResponse.Success(newsResponse)
//        Mockito.`when`(newsApi.httpClient.safeRequest<List<NewsResponse>>(HttpRoutes.GET_NEWS_COLLECTIONS) as ApiResponse.Success)
//            .thenReturn(response)
//        val result = repository.getNews()
//        val model = Resource.Success(NewsModel.mapNewsModel(newsResponse))
//        TestCase.assertEquals(model, result)
    }

}