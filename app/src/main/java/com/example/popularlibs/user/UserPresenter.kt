package com.example.popularlibs.user

import com.example.popularlibs.user.di.GitHubUserReposRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UserPresenter(private val userLogin: String) : MvpPresenter<UserView>() {

    @Inject
    lateinit var glideWrapper: GlideWrapper

    @Inject
    lateinit var userReposRepository: GitHubUserReposRepository

    override fun onFirstViewAttach() {
        userReposRepository.getUserRepos(userLogin)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                viewState.setProgressBarVisibility(true)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate {
                viewState.setProgressBarVisibility(false)
            }
            .subscribe({
                viewState.showUserRepos(it)
            }, { error ->
                error.message?.let { viewState.showError(it) }
            })
    }
}