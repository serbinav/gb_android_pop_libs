package com.example.popularlibs.di

import com.example.popularlibs.data.GitHubUserRepository
import com.example.popularlibs.data.GitHubUserRepositoryImpl
import com.example.popularlibs.data.retrofit.GitHubApi
import com.example.popularlibs.data.room.DBStorage
import com.example.popularlibs.user.di.GitHubUserReposRepository
import com.example.popularlibs.user.di.GitHubUserReposRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(@Named("prod") api: GitHubApi, room: DBStorage): GitHubUserRepository {
        return GitHubUserRepositoryImpl(api, room)
    }

    @Provides
    fun provideReposRepository(@Named("prod") api: GitHubApi, room: DBStorage): GitHubUserReposRepository {
        return GitHubUserReposRepositoryImpl(api, room)
    }
}
