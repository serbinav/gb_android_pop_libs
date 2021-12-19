package com.example.popularlibs.exponentiation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.popularlibs.R
import com.example.popularlibs.databinding.FragmentExponentiationBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ExponentiationFragment : MvpAppCompatFragment(R.layout.fragment_exponentiation),
    ExponentiationView {

    private lateinit var binding: FragmentExponentiationBinding
    private val presenter by moxyPresenter { ExponentiationPresenter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentExponentiationBinding.bind(view)

        binding.btnCalculate.setOnClickListener {
            presenter.startCount(
                binding.exponentiation.text.toString(),
            )
        }
    }

    override fun onDestroyView() {
        presenter.dispose()
        super.onDestroyView()
    }

    companion object {
        fun newInstance(): ExponentiationFragment = ExponentiationFragment()
    }

    override fun showResult(number: Int) {
        binding.exponentiationResult.text =
            String.format(getString(R.string.success_exponentiation), number)
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}