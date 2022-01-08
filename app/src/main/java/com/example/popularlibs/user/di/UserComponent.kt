package com.example.popularlibs.user.di

import com.example.popularlibs.user.UserPresenter
import dagger.Subcomponent
import javax.inject.Scope

@FragmentScope
@Subcomponent(
    modules = [AllDependenciesModule::class]
)
interface UserComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): UserComponent
    }

    fun inject(activity: UserPresenter)
}

@Scope
annotation class FragmentScope