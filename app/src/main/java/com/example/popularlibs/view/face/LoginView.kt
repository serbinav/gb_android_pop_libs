package com.example.popularlibs.view.face

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface LoginView: MvpView {

    fun showError()
}
