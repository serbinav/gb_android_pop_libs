package com.example.popularlibs.user.di

import com.example.popularlibs.data.retrofit.GitHubApi
import com.example.popularlibs.data.room.DBStorage
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UserReposModule {

    @FragmentScope
    @Provides
    fun provideReposRepository(
        @Named("prod") api: GitHubApi,
        room: DBStorage
    ): GitHubUserReposRepository {
        return GitHubUserReposRepositoryImpl(
            api,
            room
        )
    }
}