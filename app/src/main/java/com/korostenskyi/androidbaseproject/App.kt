package com.korostenskyi.androidbaseproject

import android.app.Application
import com.korostenskyi.androidbaseproject.di.applicationModule
import com.korostenskyi.androidbaseproject.ui.presentation.di.presentationModule
import com.korostenskyi.data.di.dataModule
import com.korostenskyi.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        initTimber()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(applicationModule + presentationModule + dataModule + domainModule)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
