package com.example.popularlibs.di

import android.content.Context
import com.example.popularlibs.MainActivity
import com.example.popularlibs.login.LoginPresenter
import com.example.popularlibs.user.di.UserComponent
import com.example.popularlibs.users.UsersPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        CiceroneModule::class,
        RepositoryModule::class,
        RoomModule::class
    ])

interface ApplicationComponent {

    fun provideUserComponent(): UserComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: UsersPresenter)
    fun inject(activity: LoginPresenter)
}
