package com.example.popularlibs.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.popularlibs.R
import com.example.popularlibs.databinding.FragmentLoginBinding
import com.example.popularlibs.presenter.LoginPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class LoginFragment : MvpAppCompatFragment(R.layout.fragment_login),
    LoginView {

    private lateinit var binding: FragmentLoginBinding
    private val presenter by moxyPresenter { LoginPresenter() }
    private var onClickAccept: OnClickAccept? = null

    interface OnClickAccept {
        fun onClickAccept(login: String, password: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnClickAccept) {
            onClickAccept = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        onClickAccept = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.btnAccept.setOnClickListener {
            presenter.btnAcceptClick(
                binding.login.text.toString(),
                binding.password.text.toString()
            )
            if (!binding.login.text.isNullOrEmpty() && !binding.password.text.isNullOrEmpty()) {
                onClickAccept?.onClickAccept(
                    binding.login.text.toString(),
                    binding.password.text.toString()
                )
            }
        }
    }

    override fun showError() {
        Toast.makeText(requireContext(), getString(R.string.error_login), Toast.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance(): LoginFragment = LoginFragment()
    }
}