package com.katilijiwoadiwiyono.newsapp.di


import com.katilijiwoadiwiyono.newsapp.features.main.MainSharedViewModel
import com.katilijiwoadiwiyono.newsapp.features.main.dashboard.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { MainSharedViewModel() }
}