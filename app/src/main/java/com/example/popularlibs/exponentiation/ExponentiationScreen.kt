package com.example.popularlibs.exponentiation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object ExponentiationScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        ExponentiationFragment.newInstance()
}