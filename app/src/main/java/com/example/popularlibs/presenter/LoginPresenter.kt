package com.example.popularlibs.presenter

import com.example.popularlibs.model.LoginModel
import com.example.popularlibs.view.SuccessAuthorizationScreen
import com.example.popularlibs.view.face.LoginView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class LoginPresenter(private val router: Router) : MvpPresenter<LoginView>() {

    private val model = LoginModel()

    fun btnAcceptClick(login: String, password: String) {
        if (login.isNotEmpty() && password.isNotEmpty()) {
            model.setPair(Pair(login, password))

            router.navigateTo(SuccessAuthorizationScreen(login, password))
            return
        }
        viewState.showError()
    }
}