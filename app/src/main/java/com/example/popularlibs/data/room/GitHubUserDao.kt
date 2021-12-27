package com.example.popularlibs.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.popularlibs.data.GitHubUser
import io.reactivex.rxjava3.core.Single

@Dao
interface GitHubUserDao {

    @Query("SELECT * FROM GitHubUserTable")
    fun getUsers(): Single<List<GitHubUser>>

    @Query("SELECT * FROM GitHubUserTable WHERE login LIKE :login LIMIT 1")
    fun getUserByLogin(login: String): Single<GitHubUser>

    @Insert(onConflict = REPLACE)
    fun saveUser(users: List<GitHubUser>)

    @Insert(onConflict = REPLACE)
    fun saveUser(user: GitHubUser)

}