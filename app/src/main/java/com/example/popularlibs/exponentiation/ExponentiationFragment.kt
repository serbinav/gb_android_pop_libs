package com.example.popularlibs.exponentiation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popularlibs.App
import com.example.popularlibs.R
import com.example.popularlibs.databinding.FragmentExponentiationBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ExponentiationFragment : MvpAppCompatFragment(R.layout.fragment_exponentiation), ExponentiationView{

    private lateinit var binding: FragmentExponentiationBinding
    private val presenter by moxyPresenter { ExponentiationPresenter(App.instance.router) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exponentiation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentExponentiationBinding.bind(view)
    }

    companion object {
        fun newInstance(): ExponentiationFragment = ExponentiationFragment()
    }
}