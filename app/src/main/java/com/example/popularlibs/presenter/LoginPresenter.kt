package com.example.popularlibs.presenter

import com.example.popularlibs.model.LoginModel
import com.example.popularlibs.view.face.LoginView
import moxy.MvpPresenter

class LoginPresenter : MvpPresenter<LoginView>() {

    private val model = LoginModel()

    fun btnAcceptClick(login: String?, password: String?) {
        if (!login.isNullOrEmpty() && !password.isNullOrEmpty()) {
            model.setPair(login, password)
            return
        }
        viewState.showError()
    }
}