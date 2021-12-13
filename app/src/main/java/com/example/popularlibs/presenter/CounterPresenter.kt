package com.example.popularlibs.presenter

import com.example.popularlibs.*
import com.example.popularlibs.model.CountersModel
import com.example.popularlibs.view.face.CounterView
import moxy.MvpPresenter

class CounterPresenter : MvpPresenter<CounterView>() {

    private val mapper = EnumToIndexMapper()
    private val model = CountersModel(mapper)

    fun counterClick(type: ButtonTypeEnum) {
        val nextValue = model.next(type)
        val uiModel = ButtonUiModel(type, nextValue.toString())
        viewState.setButtonText(uiModel)
    }
}