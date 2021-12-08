package com.example.popularlibs

class MainPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun counterOneClick() {
            val nextValue = model.next(0)
            view.setButtonOneText(nextValue.toString())
    }

    fun counterTwoClick() {
            val nextValue = model.next(1)
            view.setButtonTwoText(nextValue.toString())
    }

    fun counterThreeClick() {
            val nextValue = model.next(2)
            view.setButtonThreeText(nextValue.toString())
    }
}