package com.example.popularlibs.model

class LoginModel {

    private var loginPasswordPair = mutableListOf("", "")

    fun getPair(): Pair<String, String> {
        return Pair(loginPasswordPair[0], loginPasswordPair[1])
    }

    fun setPair(loginPair: Pair<String,String>) {
        loginPasswordPair[0] = loginPair.first
        loginPasswordPair[1] = loginPair.second
    }
}