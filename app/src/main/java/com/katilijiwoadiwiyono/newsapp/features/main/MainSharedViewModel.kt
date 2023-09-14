package com.katilijiwoadiwiyono.newsapp.features.main

import androidx.lifecycle.ViewModel
import com.katilijiwoadiwiyono.core.domain.model.NewsModel

interface IMainSharedViewModel{
    val newsModel: NewsModel?
    fun setNewsModel(newsModel: NewsModel)
}

class FakeSharedViewModel : IMainSharedViewModel {
    override val newsModel: NewsModel? = null
    override fun setNewsModel(newsModel: NewsModel) {}
}
class MainSharedViewModel: ViewModel(), IMainSharedViewModel {
    override val newsModel: NewsModel?
        get() = _newsModel
    private var _newsModel: NewsModel? = null

    override fun setNewsModel(newsModel: NewsModel) {
        _newsModel = newsModel
    }
}