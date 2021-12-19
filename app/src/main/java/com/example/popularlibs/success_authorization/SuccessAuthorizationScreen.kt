package com.example.popularlibs.success_authorization

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.popularlibs.success_authorization.SuccessAuthorizationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class SuccessAuthorizationScreen(private val login: String, private val password: String) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        SuccessAuthorizationFragment.newInstance(login, password)
}