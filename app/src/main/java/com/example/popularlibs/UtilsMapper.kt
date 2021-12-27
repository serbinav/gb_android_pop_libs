package com.example.popularlibs

import com.example.popularlibs.data.GitHubUser
import com.example.popularlibs.data.GitHubUserInfo
import io.reactivex.rxjava3.core.Single
import java.lang.IndexOutOfBoundsException

class UtilsMapper {

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

    fun mapGitHubUserToGitHubUserInfo(user: GitHubUser): Single<GitHubUserInfo> {
        return Single.fromCallable {
            GitHubUserInfo(
                id = user.id,
                login = user.login,
                avatarUrl = user.avatarUrl,
                type = user.type
            )
        }
    }
}