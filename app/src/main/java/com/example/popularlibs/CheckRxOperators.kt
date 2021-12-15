package com.example.popularlibs

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun main() {

//    Оператор flatMap применяет функцию к каждому излучаемому элементу,
//    но эта функция возвращает Obsevable.
//    То есть один излучаемый элемент исходного источника через flatMap порождает другие.
//    Проще говоря, flatMap из каждого элемента создаёт новый источник,
//    после чего выполняет слияние этих источников
//
//    concatMap оператор выдает похожий с flatMap результат,
//    меняется только последовательность эмиттируемых данных.
//    concatMap поддерживает порядок данных и ожидает исполнения текущего Observable.
//
//    switchMap кардинально отличается от flatMap и concatMap. Он лучше всего подходит,
//    если вы хотите проигнорировать промежуточные результаты и рассмотреть последний.
//    switchMap отписывается от предыдущего источника Observable всякий раз, когда новый элемент
//    начинает излучать данные, тем самым всегда эмитит данные из текущего Observable.

//    concatMap
//    1a 1382
//    2a 1895
//    3a 2408
//    4a 2909

//    flatMap
//    1a 1389
//    2a 1390
//    3a 1390
//    4a 1390

//    switchMap
//    4a 1319

    val currentTime = System.currentTimeMillis()
    Observable.fromIterable(listOf(1,2,3,4)).delay(500, TimeUnit.MILLISECONDS)
        .switchMap {
            Observable.just(it.toString()).delay(500, TimeUnit.MILLISECONDS)
        }
        .subscribe {
            println(it.plus("a ").plus(System.currentTimeMillis() - currentTime))
        }

    Thread.sleep(15000)
}