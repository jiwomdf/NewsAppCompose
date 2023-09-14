package com.katilijiwoadiwiyono.newsapp.features.main.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katilijiwoadiwiyono.core.domain.model.NewsModel
import com.katilijiwoadiwiyono.core.domain.usecase.NewsUseCase
import kotlinx.coroutines.launch

interface IDetailViewModel {
    val newsDetail: MutableState<NewsModel?>
    fun getNewsDetail(id: Int)
}

class FakeDetailViewModel : IDetailViewModel {
    override val newsDetail = mutableStateOf<NewsModel?>(null)
    override fun getNewsDetail(id: Int) {}
}

class DetailViewModel(
    private val newsUseCase: NewsUseCase
): ViewModel(), IDetailViewModel {

    override val newsDetail  = mutableStateOf<NewsModel?>(null)

    override fun getNewsDetail(id: Int){
        viewModelScope.launch {
            newsDetail.value = newsUseCase.getNewsDetail(id)
        }
    }

}