package com.katilijiwoadiwiyono.core.di.network

import com.katilijiwoadiwiyono.core.data.repository.NewsRepository
import com.katilijiwoadiwiyono.core.data.repository.NewsRepositoryImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    single {
        NewsRepositoryImpl(get())
    } bind NewsRepository::class
}