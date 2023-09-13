package com.katilijiwoadiwiyono.newsapp.features.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katilijiwoadiwiyono.core.domain.usecase.NewsUseCase
import kotlinx.coroutines.launch

class MainViewModel constructor(private val newsUseCase: NewsUseCase): ViewModel() {

    fun getNews(){
        viewModelScope.launch {
            newsUseCase.getNews()
        }
    }

}