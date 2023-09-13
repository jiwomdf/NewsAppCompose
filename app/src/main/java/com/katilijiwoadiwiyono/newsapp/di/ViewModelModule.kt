package com.katilijiwoadiwiyono.newsapp.di


import com.katilijiwoadiwiyono.newsapp.features.dashboard.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}