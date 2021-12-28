package com.example.popularlibs

import android.app.Application
import com.example.popularlibs.di.ApplicationComponent
import com.example.popularlibs.di.DaggerApplicationComponent

class App : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}