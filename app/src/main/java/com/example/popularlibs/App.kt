package com.example.popularlibs

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.github.terrakok.cicerone.Cicerone

class App : Application() {

    @SuppressLint("StaticFieldLeak")
    object ContextHolder {
        lateinit var context: Context
    }

    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigationHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        instance = this
        ContextHolder.context = this
    }

    companion object {
        lateinit var instance: App
            private set
    }
}