package com.katilijiwoadiwiyono.newsapp.feature.main.dashboard

import com.katilijiwoadiwiyono.core.domain.usecase.NewsUseCase
import com.katilijiwoadiwiyono.newsapp.features.main.dashboard.MainViewModel
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule


class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Mock
    private lateinit var useCase: NewsUseCase

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Test
    fun getMovies() {

    }

}