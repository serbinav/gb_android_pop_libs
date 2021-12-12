package com.example.popularlibs.presenter

import com.example.popularlibs.view.SuccessAuthorizationView
import com.example.popularlibs.model.SuccessAuthorizationModel

class SuccessAuthorizationPresenter(private val view: SuccessAuthorizationView) {

    private val model = SuccessAuthorizationModel()

    fun openFragment(login: String?, password: String?) {
        if (!login.isNullOrEmpty() && !password.isNullOrEmpty()) {
            model.setPair(login, password)
            view.setHelloText(model.getPair())
        }
    }
}