package com.example.popularlibs.user

import com.example.popularlibs.data.GitHubUserInfo
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : MvpView {

    /**
     * Показывает информацию о пользователе.
     * @param user пользователь
     */
    @SingleState
    fun showUserInfo(userInfo: GitHubUserInfo)

}