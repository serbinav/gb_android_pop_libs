package com.example.popularlibs.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popularlibs.databinding.FragmentSuccessAuthorizationBinding

private const val LOGIN_KEY = "LOGIN_KEY"
private const val PASSWORD_KEY = "PASSWORD_KEY"

class SuccessAuthorizationFragment : Fragment() {

    private var _binding: FragmentSuccessAuthorizationBinding? = null
    private val binding get() = _binding!!
    private var login: String? = null
    private var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            login = it.getString(LOGIN_KEY)
            password = it.getString(PASSWORD_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuccessAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!login.isNullOrEmpty() && !password.isNullOrEmpty()) {
            binding.text.text = String.format(
                "Success Login " + System.lineSeparator() + "Hello %s with password %s",
                login,
                password
            )
        }
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