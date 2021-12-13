package com.example.popularlibs.model

class LoginModel {

    private var loginPasswordPair = mutableListOf("", "")

    fun getPair(): Pair<String, String> {
        return Pair(loginPasswordPair[0], loginPasswordPair[1])
    }

    fun setPair(login: String, password: String) {
        loginPasswordPair[0] = login
        loginPasswordPair[1] = password
    }
}