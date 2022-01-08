package com.example.popularlibs.data

import com.example.popularlibs.UtilsMapper
import com.example.popularlibs.data.retrofit.GitHubApi
import com.example.popularlibs.data.room.DBStorage
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GitHubUserRepositoryImpl
@Inject
constructor(
    private val gitHubApi: GitHubApi,
    private val roomDb: DBStorage
) : GitHubUserRepository {

    override fun getUsers(): Single<List<GitHubUser>> {
        return roomDb.getGitHubUserDao().getUsers()
            .flatMap {
                if (it.isEmpty()) {
                    gitHubApi.fetchUsers()
                        .map { resultFromServer ->
                            roomDb.getGitHubUserDao().saveUser(resultFromServer)
                            resultFromServer
                        }
                } else {
                    Single.just(it)
                }
            }
    }

    override fun getUserByLogin(login: String): Single<GitHubUserInfo> {
        return roomDb.getGitHubUserDao().getUserByLogin(login)
            .flatMap {
                UtilsMapper().mapGitHubUserToGitHubUserInfo(it)
            }
    }

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