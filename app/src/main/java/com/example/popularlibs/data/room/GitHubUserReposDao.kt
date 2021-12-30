package com.example.popularlibs.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.popularlibs.data.GitHubUserRepos
import io.reactivex.rxjava3.core.Single

@Dao
interface GitHubUserReposDao {

    @Query("SELECT * FROM GitHubUserReposTable WHERE fullName LIKE :login")
    fun getUserReposByLogin(login: String): Single<List<GitHubUserRepos>>

    @Query("SELECT * FROM GitHubUserReposTable WHERE fullName LIKE :login LIMIT 1")
    fun getUserFirstReposByLogin(login: String): Single<GitHubUserRepos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUserRepos(users: List<GitHubUserRepos>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUserRepos(user: GitHubUserRepos)

}
