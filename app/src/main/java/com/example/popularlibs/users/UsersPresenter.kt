package com.example.popularlibs.users

import com.example.popularlibs.data.GitHubUserRepository
import com.example.popularlibs.user.UserScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router
) : MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        updateContent()
    }

    fun goToNextScreen(login: String) {
        router.navigateTo(UserScreen(login))
    }

    private fun updateContent() {
        userRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showUsers(it)
            }, { error ->
                error.message?.let { viewState.showError(it) }
            })
    }
}