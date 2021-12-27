package com.example.popularlibs.data

import com.example.popularlibs.data.retrofit.GitHubApiFactory
import com.example.popularlibs.data.room.RoomFactory
import io.reactivex.rxjava3.core.Single

class GitHubUserRepositoryImpl : GitHubUserRepository {

    private val gitHubApi = GitHubApiFactory.create()
    private val roomDb = RoomFactory.create().getGitHubUserDao()

    override fun getUsers(): Single<List<GitHubUser>> {
        return roomDb.getUsers()
            .flatMap {
                if (it.isEmpty()) {
                    gitHubApi.fetchUsers()
                        .map { resultFromServer ->
                            roomDb.saveUser(resultFromServer)
                            resultFromServer
                        }
                } else {
                    Single.just(it)
                }
            }
    }

    override fun getUserByLogin(login: String): Single<GitHubUserInfo> {
        return gitHubApi.fetchUserByLogin(login)
    }
}