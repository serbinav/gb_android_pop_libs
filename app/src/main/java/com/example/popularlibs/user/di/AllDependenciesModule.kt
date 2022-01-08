package com.example.popularlibs.user.di

import android.content.Context
import com.example.popularlibs.user.GlideWrapper
import dagger.Module
import dagger.Provides

@Module
class AllDependenciesModule {

    @FragmentScope
    @Provides
    fun provideGlideWrapper(context: Context): GlideWrapper {
        return GlideWrapper(context)
    }
}