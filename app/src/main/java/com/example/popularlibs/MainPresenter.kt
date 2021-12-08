package com.example.popularlibs

class MainPresenter(val view: MainView) {

    val model = CountersModel()

    //error
    fun counterClick(id: Int) {
        when (id) {
            R.id.btn_one -> {
                val nextValue = model.next(0)
                view.setButtonText(0, nextValue.toString())
            }
            R.id.btn_two -> {
                val nextValue = model.next(1)
                view.setButtonText(1, nextValue.toString())
            }
            R.id.btn_three -> {
                val nextValue = model.next(2)
                view.setButtonText(2, nextValue.toString())
            }
        }
    }
}