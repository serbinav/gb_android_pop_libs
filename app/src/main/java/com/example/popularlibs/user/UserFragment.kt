package com.example.popularlibs.user

import android.os.Bundle
import android.view.View
import android.widget.Toast
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
            App.instance.component.inject(this)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentUserBinding.bind(view)
        viewBinding.userLogin.editText?.setText(userLogin)
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
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
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