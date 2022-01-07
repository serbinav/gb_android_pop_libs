package com.example.popularlibs.user

import com.example.popularlibs.data.GitHubUserInfo
import com.example.popularlibs.data.GitHubUserRepos
import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution
import moxy.viewstate.strategy.alias.SingleState

interface UserView : MvpView {

    /**
     * Показывает информацию о пользователе.
     */
    @SingleState
    fun showUserInfo(userInfo: GitHubUserInfo)

    @SingleState
    fun showUserRepos(userRepos: GitHubUserRepos)

    @OneExecution
    fun showError(message: String)
}