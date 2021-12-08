package com.example.popularlibs

import java.lang.IndexOutOfBoundsException

class EnumToIndexMapper {

    fun mapEnumToIndex(enum: ButtonTypeEnum): Int {
        return when (enum) {
            ButtonTypeEnum.FIRST_BUTTON -> 0
            ButtonTypeEnum.SECOND_BUTTON -> 1
            ButtonTypeEnum.THIRD_BUTTON -> 2
        }
    }

    fun mapIndexToEnum(index: Int): ButtonTypeEnum {
        return when (index) {
            0 -> ButtonTypeEnum.FIRST_BUTTON
            1 -> ButtonTypeEnum.SECOND_BUTTON
            2 -> ButtonTypeEnum.THIRD_BUTTON
            else -> throw IndexOutOfBoundsException("not allow this id")
        }
    }
}