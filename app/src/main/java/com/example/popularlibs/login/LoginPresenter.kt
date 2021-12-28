package com.example.popularlibs.login

import com.example.popularlibs.success_authorization.SuccessAuthorizationScreen
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class LoginPresenter : MvpPresenter<LoginView>() {

    @Inject
    lateinit var router: Router

    private val model = LoginModel()

    fun btnAcceptClick(login: String, password: String) {
        if (login.isNotEmpty() && password.isNotEmpty()) {
            model.setPair(Pair(login, password)).andThen {
                router.navigateTo(SuccessAuthorizationScreen(login, password))
            }
                .subscribe()
            return
        }
        viewState.showError()
    }
}