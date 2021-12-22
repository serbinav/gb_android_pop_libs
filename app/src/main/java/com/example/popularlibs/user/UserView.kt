package com.example.popularlibs.user

import com.example.popularlibs.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : MvpView {

    /**
     * Показывает информацию о пользователе.
     * @param user пользователь
     */
    @SingleState
    fun showUser(user: GitHubUser)

}