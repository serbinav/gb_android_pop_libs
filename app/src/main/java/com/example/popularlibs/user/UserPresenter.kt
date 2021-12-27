package com.example.popularlibs.user

import com.example.popularlibs.data.GitHubUserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        userRepository.getUserByLogin(userLogin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showUserInfo(it)
            }, { error ->
                error.message?.let { viewState.showError(it) }
            })
    }
}