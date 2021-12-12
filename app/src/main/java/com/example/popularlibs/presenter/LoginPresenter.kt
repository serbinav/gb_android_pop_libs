package com.example.popularlibs.presenter

import com.example.popularlibs.model.LoginModel

class LoginPresenter{
    private val model = LoginModel()

    fun btnAcceptClick(login: String?, password: String?) {
        if (!login.isNullOrEmpty() && !password.isNullOrEmpty()) {
            model.setPair(login, password)
        }
    }
}