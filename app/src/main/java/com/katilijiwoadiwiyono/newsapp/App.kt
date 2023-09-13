package com.katilijiwoadiwiyono.newsapp

import android.app.Application
import com.katilijiwoadiwiyono.core.di.network.remoteModule
import com.katilijiwoadiwiyono.core.di.network.repositoryModule
import com.katilijiwoadiwiyono.core.di.network.useCaseModule
import com.katilijiwoadiwiyono.newsapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(listOf(
                viewModelModule,
                useCaseModule,
                repositoryModule,
                remoteModule,
            ))
        }
    }
}