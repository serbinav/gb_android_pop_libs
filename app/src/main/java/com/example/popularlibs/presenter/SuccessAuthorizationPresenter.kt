package com.example.popularlibs.presenter

import com.example.popularlibs.view.face.SuccessAuthorizationView
import com.example.popularlibs.model.SuccessAuthorizationModel
import moxy.MvpPresenter

class SuccessAuthorizationPresenter(private val login: String, private val password: String) :
    MvpPresenter<SuccessAuthorizationView>() {

    private val model = SuccessAuthorizationModel()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if (login.isNotEmpty() && password.isNotEmpty()) {

            model.setPair(Pair(login, password))
            viewState.setHelloText(model.getPair())
        }
    }
}