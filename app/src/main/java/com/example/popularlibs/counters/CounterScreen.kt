package com.example.popularlibs.counters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object CounterScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        CounterFragment.newInstance()
}