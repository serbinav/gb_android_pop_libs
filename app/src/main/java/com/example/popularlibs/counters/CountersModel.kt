package com.example.popularlibs.counters

import com.example.popularlibs.ButtonTypeEnum
import com.example.popularlibs.EnumToIndexMapper

class CountersModel(private val mapper: EnumToIndexMapper) {

    private val counters = mutableListOf(0, 0, 0)

    private fun getCurrent(enum: ButtonTypeEnum): Int {
        val index = mapper.mapEnumToIndex(enum)
        return counters[index]
    }

    fun next(enum: ButtonTypeEnum): Int {
        val index = mapper.mapEnumToIndex(enum)
        counters[index]++
        return getCurrent(enum)
    }
}