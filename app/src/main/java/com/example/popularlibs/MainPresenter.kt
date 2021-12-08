package com.example.popularlibs

class MainPresenter(private val view: MainView) {

    private val mapper = EnumToIndexMapper()
    private val model = CountersModel(mapper)

    fun counterClick(type: ButtonTypeEnum) {
        val nextValue = model.next(type)
        val uiModel = ButtonUiModel(type, nextValue.toString())
        view.setButtonText(uiModel)
    }
}