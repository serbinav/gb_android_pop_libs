package com.example.popularlibs.success_authorization

import android.os.Bundle
import android.view.View
import moxy.ktx.moxyPresenter
import com.example.popularlibs.R
import com.example.popularlibs.databinding.FragmentSuccessAuthorizationBinding
import moxy.MvpAppCompatFragment


class SuccessAuthorizationFragment : MvpAppCompatFragment(R.layout.fragment_success_authorization),
    SuccessAuthorizationView {

    private val login by lazy { arguments?.getString(LOGIN_KEY).orEmpty() }
    private val password by lazy { arguments?.getString(PASSWORD_KEY).orEmpty() }

    private lateinit var binding: FragmentSuccessAuthorizationBinding
    private val presenter by moxyPresenter { SuccessAuthorizationPresenter(login, password) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSuccessAuthorizationBinding.bind(view)
    }

    override fun setHelloText(pair: Pair<String, String>) {
        binding.text.text = String.format(
            "Success Login " + System.lineSeparator() + "Hello %s with password %s",
            pair.first,
            pair.second
        )
    }

    companion object {
        private const val LOGIN_KEY = "LOGIN_KEY"
        private const val PASSWORD_KEY = "PASSWORD_KEY"

        @JvmStatic
        fun newInstance(login: String, password: String) =
            SuccessAuthorizationFragment().apply {
                arguments = Bundle().apply {
                    putString(LOGIN_KEY, login)
                    putString(PASSWORD_KEY, password)
                }
            }
    }
}