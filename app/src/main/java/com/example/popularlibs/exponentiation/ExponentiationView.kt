package com.example.popularlibs.exponentiation

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface ExponentiationView: MvpView  {

    fun showResult(number: Int)
    fun showError(message: String)
}
