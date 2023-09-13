package com.katilijiwoadiwiyono.core.di.network

import com.katilijiwoadiwiyono.core.domain.usecase.NewsInteractor
import com.katilijiwoadiwiyono.core.domain.usecase.NewsUseCase
import org.koin.dsl.bind
import org.koin.dsl.module

val useCaseModule = module {
    single {
        NewsInteractor(get())
    } bind NewsUseCase::class
}