package com.katilijiwoadiwiyono.core.di.network

import com.katilijiwoadiwiyono.core.data.remote.network.NewsApi
import com.katilijiwoadiwiyono.core.data.remote.source.RemoteDataSource
import com.katilijiwoadiwiyono.core.data.remote.source.RemoteDataSourceImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteModule = module {
    single {
        RemoteDataSourceImpl(NewsApi())
    } bind RemoteDataSource::class
}