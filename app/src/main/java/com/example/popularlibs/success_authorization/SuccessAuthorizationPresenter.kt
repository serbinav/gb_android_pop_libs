package com.example.popularlibs.success_authorization

import moxy.MvpPresenter

class SuccessAuthorizationPresenter(private val login: String, private val password: String) :
    MvpPresenter<SuccessAuthorizationView>() {

    private val model = SuccessAuthorizationModel()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if (login.isNotEmpty() && password.isNotEmpty()) {
            model.setPair(Pair(login, password))
                .andThen {
                    model.getPair().map {
                        viewState.setHelloText(it)
                    }
                        .subscribe()
                }
                .subscribe()
        }
    }
}