package com.rodionov.osport.app

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.rodionov.osport.BuildConfig
import com.rodionov.osport.app.di.module.*
import com.rodionov.base.platform.LocaleHelper
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class OSportApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@OSportApp)
//            androidLogger()
            modules(listOf(appModule, networkModule, repositoryModule, storageModule, viewModelModule, databaseModule, useCaseModule))
        }

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(base))
    }
}