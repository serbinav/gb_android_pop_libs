package com.example.popularlibs.data

import io.reactivex.rxjava3.core.Single

interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(login: String): Single<GitHubUserInfo>

    fun getUserRepos(login: String): Single<GitHubUserRepos>
}