package com.example.popularlibs.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.popularlibs.App
import com.example.popularlibs.R
import com.example.popularlibs.databinding.FragmentLoginBinding
import com.example.popularlibs.presenter.LoginPresenter
import com.example.popularlibs.view.face.LoginView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class LoginFragment : MvpAppCompatFragment(R.layout.fragment_login),
    LoginView {

    private lateinit var binding: FragmentLoginBinding
    private val presenter by moxyPresenter { LoginPresenter(App.instance.router) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.btnAccept.setOnClickListener {
            presenter.btnAcceptClick(
                binding.login.text.toString(),
                binding.password.text.toString()
            )
        }
    }

    override fun showError() {
        Toast.makeText(requireContext(), getString(R.string.error_login), Toast.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance(): LoginFragment = LoginFragment()
    }
}