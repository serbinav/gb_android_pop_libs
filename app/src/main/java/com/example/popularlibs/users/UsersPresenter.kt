package com.example.popularlibs.users

import com.example.popularlibs.data.GitHubUserRepository
import com.example.popularlibs.user.UserScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UsersPresenter : MvpPresenter<UsersView>() {

    @Inject
    lateinit var userRepository: GitHubUserRepository

    @Inject
    lateinit var router: Router

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