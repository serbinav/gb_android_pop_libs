package com.example.popularlibs.user

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.popularlibs.App
import com.example.popularlibs.R
import com.example.popularlibs.data.GitHubUserInfo
import com.example.popularlibs.data.GitHubUserRepos
import com.example.popularlibs.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), UserView {

    private lateinit var viewBinding: FragmentUserBinding

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin
        ).apply {
            App.instance.initUserComponent().inject(this)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentUserBinding.bind(view)
        viewBinding.userLogin.editText?.setText(userLogin)
    }

    override fun onDestroy() {
        App.instance.destroyUserComponent()
        super.onDestroy()
    }

    override fun showUserInfo(userInfo: GitHubUserInfo) {
        Glide.with(viewBinding.userAvatar.context)
            .load(userInfo.avatarUrl)
            .into(viewBinding.userAvatar)

        viewBinding.userLogin.editText?.setText(userInfo.login)
        viewBinding.userName.editText?.setText(userInfo.name)
        viewBinding.userLocation.editText?.setText(userInfo.location)
    }

    override fun showUserRepos(userRepos: GitHubUserRepos) {
        viewBinding.userName.editText?.setText(userRepos.name)
        viewBinding.fullName.editText?.setText(userRepos.fullName)
        viewBinding.description.editText?.setText(userRepos.description)
    }

    override fun showError(message: String) {
        requireActivity().let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Ошибка!")
                .setMessage(message)
                .setPositiveButton("ОК") { dialog, _ ->
                    dialog.cancel()
                }
            builder.create().show()
        }
    }

    override fun setProgressBarVisibility(isVisible: Boolean) {
        val visibility = if (isVisible) {
            View.VISIBLE
        } else {
            View.GONE
        }
        viewBinding.includeLoadingLayout.loadingLayout.visibility = visibility
    }

    companion object {
        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_LOGIN, userId)
                }
            }
    }
}