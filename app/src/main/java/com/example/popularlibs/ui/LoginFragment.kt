package com.example.popularlibs.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popularlibs.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    interface OnClickAccept {
        fun onClickAccept(login: String, password: String)
    }

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private var onClickAccept: OnClickAccept? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
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

        binding.btnAccept.setOnClickListener {
            if (!binding.login.text.isNullOrEmpty() && !binding.password.text.isNullOrEmpty()) {
                onClickAccept?.onClickAccept(
                    binding.login.text.toString(),
                    binding.password.text.toString()
                )
            }
        }
    }
}