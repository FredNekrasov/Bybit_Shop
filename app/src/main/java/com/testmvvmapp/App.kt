package com.testmvvmapp

import android.app.Application
import com.testmvvmapp.features.bybit.di.bybitModule
import com.testmvvmapp.features.user.di.userModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(userModule, bybitModule)
        }
    }
}