package com.example.popularlibs.user.di

import com.example.popularlibs.data.GitHubUserRepos
import com.example.popularlibs.data.retrofit.GitHubApi
import com.example.popularlibs.data.room.DBStorage
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GitHubUserReposRepositoryImpl
@Inject
constructor(
    private val gitHubApi: GitHubApi,
    private val roomDb: DBStorage
) : GitHubUserReposRepository {

    override fun getUserRepos(login: String): Single<GitHubUserRepos> {
        return roomDb.getGitHubUserReposDao().getUserReposByLogin(login)
            .flatMap {
                if (it.isEmpty()) {
                    gitHubApi.fetchUserRepos(login)
                        .map { resultFromServer ->
                            resultFromServer
                                .filter { data -> data.fullName.contains(login) }
                        }
                        .map { resultFromServer ->
                            roomDb.getGitHubUserReposDao().saveUserRepos(resultFromServer)
                            resultFromServer
                        }
                        .flatMap { resultFromServer ->
                            Single.just(resultFromServer.first())
                        }
                } else {
                    roomDb.getGitHubUserReposDao().getUserFirstReposByLogin(login)
                }
            }
    }
}