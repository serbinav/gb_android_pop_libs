package com.example.popularlibs.users

import com.example.popularlibs.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution
import moxy.viewstate.strategy.alias.SingleState

interface UsersView : MvpView {

    /**
     * Показывает список пользователей.
     * @param users список пользователей
     */
    @SingleState
    fun showUsers(users: List<GitHubUser>)

    @OneExecution
    fun showError(message: String)

    @SingleState
    fun setProgressBarVisibility(isVisible: Boolean)
}