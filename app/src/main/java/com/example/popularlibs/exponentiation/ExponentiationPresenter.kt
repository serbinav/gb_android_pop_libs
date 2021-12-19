package com.example.popularlibs.exponentiation

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.AsyncSubject

import moxy.MvpPresenter

class ExponentiationPresenter : MvpPresenter<ExponentiationView>() {

    private val model = ExponentiationModel()
    private val subject = AsyncSubject.create<String>()
    private var disposables = CompositeDisposable()

    private fun observeChanges(str: String) {
        disposables.add(
            subject
                .flatMap { checkNumberIsNotEmpty(str) }
                .flatMap { checkNumberIsInt(it) }
                .observeOn(Schedulers.computation())
                .flatMap { exponentiationNumber(it) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.showResult(it)
                }, { error ->
                    error.message?.let { viewState.showError(it) }
                })
        )
    }

    private fun checkNumberIsNotEmpty(number: String): Observable<String> {
        if (number.isNotEmpty()) {
            return Observable.just(number)
        }
        throw Exception("Данные в поле отсутствуют!")
    }

    private fun checkNumberIsInt(number: String): Observable<Int> {
        try {
            return Observable.just(number.toInt())
        } catch (ex: NumberFormatException) {
            throw Exception("Данные в поле имеют не числовой формат!")
        }
    }

    private fun exponentiationNumber(number: Int): Observable<Int> {
        return Observable.just(number * number)
    }

    fun startCount(number: String) {
        observeChanges(number)
        subject.onNext(number)
        subject.onComplete()
    }

    fun dispose() {
        disposables.dispose()
    }
}
