package com.example.popularlibs.view

import android.os.Bundle
import android.view.View
import moxy.ktx.moxyPresenter
import com.example.popularlibs.R
import com.example.popularlibs.presenter.SuccessAuthorizationPresenter
import com.example.popularlibs.databinding.FragmentSuccessAuthorizationBinding
import moxy.MvpAppCompatFragment

private const val LOGIN_KEY = "LOGIN_KEY"
private const val PASSWORD_KEY = "PASSWORD_KEY"

class SuccessAuthorizationFragment : MvpAppCompatFragment(R.layout.fragment_success_authorization),
    SuccessAuthorizationView {

    private lateinit var binding: FragmentSuccessAuthorizationBinding
    private var login: String? = null
    private var password: String? = null
    private val presenter by moxyPresenter { SuccessAuthorizationPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            login = it.getString(LOGIN_KEY)
            password = it.getString(PASSWORD_KEY)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSuccessAuthorizationBinding.bind(view)
        presenter.openFragment(login, password)
    }

    override fun setHelloText(pair: Pair<String, String>) {
        binding.text.text = String.format(
            "Success Login " + System.lineSeparator() + "Hello %s with password %s",
            pair.first,
            pair.second
        )
    }

    companion object {
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