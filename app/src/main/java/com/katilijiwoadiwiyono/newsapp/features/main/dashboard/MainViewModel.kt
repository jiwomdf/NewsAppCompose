package com.katilijiwoadiwiyono.newsapp.features.main.dashboard

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katilijiwoadiwiyono.core.domain.model.NewsModel
import com.katilijiwoadiwiyono.core.domain.usecase.NewsUseCase
import kotlinx.coroutines.launch

interface IMainViewModel {
    val news: MutableState<List<NewsModel>>
    fun getNews()
}

class FakeMainViewModel() : IMainViewModel {
    override val news = mutableStateOf<List<NewsModel>>(emptyList())
    override fun getNews() {}
}

class MainViewModel(
    private val newsUseCase: NewsUseCase
): ViewModel(), IMainViewModel {

    override val news  = mutableStateOf<List<NewsModel>>(emptyList())

    override fun getNews(){
        viewModelScope.launch {
            val test = newsUseCase.getNews()
            Log.e("jiwo", "getNews: $test")
            news.value = test
        }
    }

}