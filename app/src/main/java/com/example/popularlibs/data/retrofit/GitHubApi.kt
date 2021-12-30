package com.example.popularlibs.data.retrofit

import com.example.popularlibs.data.GitHubUser
import com.example.popularlibs.data.GitHubUserInfo
import com.example.popularlibs.data.GitHubUserRepos
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("/users")
    fun fetchUsers(): Single<List<GitHubUser>>

    @GET("/users/{login}")
    fun fetchUserByLogin(@Path("login") login: String): Single<GitHubUserInfo>

    @GET("/users/{login}/repos")
    fun fetchUserRepos(@Path("login") login: String): Single<List<GitHubUserRepos>>
}