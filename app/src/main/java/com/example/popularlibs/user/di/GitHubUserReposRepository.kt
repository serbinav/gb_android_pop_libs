package com.example.popularlibs.user.di

import com.example.popularlibs.data.GitHubUserRepos
import io.reactivex.rxjava3.core.Single

interface GitHubUserReposRepository {

    fun getUserRepos(login: String): Single<GitHubUserRepos>
}