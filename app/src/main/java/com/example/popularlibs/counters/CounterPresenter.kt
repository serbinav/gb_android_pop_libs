package com.example.popularlibs.counters

import com.example.popularlibs.*
import moxy.MvpPresenter

class CounterPresenter : MvpPresenter<CounterView>() {

    private val mapper = UtilsMapper()
    private val model = CountersModel(mapper)

    fun counterClick(type: ButtonTypeEnum) {
        val nextValue = model.next(type)
        val uiModel = ButtonUiModel(type, nextValue.toString())
        viewState.setButtonText(uiModel)
    }
}