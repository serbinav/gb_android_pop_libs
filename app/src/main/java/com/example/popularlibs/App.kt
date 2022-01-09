package com.example.popularlibs

import android.app.Application
import com.example.popularlibs.di.ApplicationComponent
import com.example.popularlibs.di.DaggerApplicationComponent
import com.example.popularlibs.user.di.UserComponent

class App : Application() {

    lateinit var component: ApplicationComponent

    private var userComponent: UserComponent? = null

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

    fun initUserComponent() = component.provideUserComponent().build().apply {
        userComponent = this
    }

    fun destroyUserComponent() {
        userComponent = null
    }
}