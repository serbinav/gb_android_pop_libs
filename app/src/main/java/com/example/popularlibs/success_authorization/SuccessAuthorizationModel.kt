package com.example.popularlibs.success_authorization

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class SuccessAuthorizationModel {

    private var loginPasswordPair = mutableListOf("", "")

    fun getPair(): Observable<Pair<String, String>> {
        return Observable.just(Pair(loginPasswordPair[0], loginPasswordPair[1]))
    }

    fun setPair(loginPair: Pair<String, String>): Completable {
        return Completable.fromAction {
            loginPasswordPair[0] = loginPair.first
            loginPasswordPair[1] = loginPair.second
        }
    }
}