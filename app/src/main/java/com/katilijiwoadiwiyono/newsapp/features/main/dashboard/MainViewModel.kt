package com.katilijiwoadiwiyono.newsapp.features.main.dashboard

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katilijiwoadiwiyono.core.domain.model.NewsModel
import com.katilijiwoadiwiyono.core.domain.usecase.NewsUseCase
import com.katilijiwoadiwiyono.core.utils.ApiResponse
import com.katilijiwoadiwiyono.core.utils.Resource
import com.katilijiwoadiwiyono.newsapp.R
import kotlinx.coroutines.launch

interface IMainViewModel {
    val news: MutableState<List<NewsModel>>
    val commonError: MutableState<Int>
    fun getNews()
}

class FakeMainViewModel : IMainViewModel {
    override val news = mutableStateOf<List<NewsModel>>(emptyList())
    override val commonError = mutableIntStateOf(0)
    override fun getNews() {}
}

class MainViewModel(
    private val newsUseCase: NewsUseCase
): ViewModel(), IMainViewModel {

    override val news  = mutableStateOf<List<NewsModel>>(emptyList())
    override val commonError = mutableIntStateOf(0)

    override fun getNews(){
        viewModelScope.launch {
            when(val response = newsUseCase.getNews()) {
                is Resource.Success -> {
                    news.value = response.data
                }
                is Resource.Error.HttpClientError,
                is Resource.Error.NetworkError -> {
                    commonError.value = R.string.please_check_your_connection
                }
                is Resource.Error.HttpServerError -> {
                    commonError.value = R.string.server_not_responding_please_try_again
                }
                is Resource.Error.UnknownError -> {
                    commonError.value = R.string.something_went_wrong
                }
            }
        }
    }

}