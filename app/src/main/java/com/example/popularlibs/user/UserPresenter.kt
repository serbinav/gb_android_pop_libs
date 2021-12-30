package com.example.popularlibs.user

import com.example.popularlibs.data.GitHubUserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UserPresenter(private val userLogin: String): MvpPresenter<UserView>() {

    @Inject
    lateinit var userRepository: GitHubUserRepository

    override fun onFirstViewAttach() {
        userRepository.getUserRepos(userLogin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            }, { error ->
                error.message?.let { viewState.showError(it) }
            })

//TODO тут нужно доработать после починки api запроса
//        userRepository.getUserByLogin(userLogin)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                viewState.showUserInfo(it)
//            }, { error ->
//                error.message?.let { viewState.showError(it) }
//            })
    }
}