package com.example.popularlibs.presenter

import com.example.popularlibs.view.SuccessAuthorizationView
import com.example.popularlibs.model.SuccessAuthorizationModel
import moxy.MvpPresenter

class SuccessAuthorizationPresenter : MvpPresenter<SuccessAuthorizationView>() {

    private val model = SuccessAuthorizationModel()

    fun openFragment(login: String?, password: String?) {
        if (!login.isNullOrEmpty() && !password.isNullOrEmpty()) {
            model.setPair(login, password)
            viewState.setHelloText(model.getPair())
        }
    }
}