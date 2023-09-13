package com.katilijiwoadiwiyono.newsapp.features.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katilijiwoadiwiyono.core.domain.usecase.NewsUseCase
import kotlinx.coroutines.launch

interface IMainViewModel {
    fun getNews()
}

class FakeMainViewModel: IMainViewModel{
    override fun getNews() {}
}

class MainViewModel(
    private val newsUseCase: NewsUseCase
): ViewModel(), IMainViewModel {

    override fun getNews(){
        viewModelScope.launch {
            val test = newsUseCase.getNews()
            Log.e("jiwo", "getNews: $test")
        }
    }

}