package com.example.popularlibs.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.popularlibs.data.GitHubUser
import com.example.popularlibs.data.GitHubUserRepos

@Database(
    exportSchema = false,
    entities = [
        GitHubUser::class,
        GitHubUserRepos::class
    ],
    version = 1
)
abstract class DBStorage : RoomDatabase() {

    abstract fun getGitHubUserDao(): GitHubUserDao
    abstract fun getGitHubUserReposDao(): GitHubUserReposDao

}