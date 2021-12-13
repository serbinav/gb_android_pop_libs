package com.example.popularlibs.view.face

import com.example.popularlibs.ButtonUiModel
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface CounterView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun setButtonText(model: ButtonUiModel)
}