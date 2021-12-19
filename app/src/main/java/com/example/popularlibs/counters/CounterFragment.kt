package com.example.popularlibs.counters

import android.os.Bundle
import android.view.View
import com.example.popularlibs.*
import com.example.popularlibs.databinding.FragmentCounterBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class CounterFragment : MvpAppCompatFragment(R.layout.fragment_counter), CounterView {

    private lateinit var binding: FragmentCounterBinding
    private val presenter by moxyPresenter { CounterPresenter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCounterBinding.bind(view)

        binding.btnOne.setOnClickListener {
            presenter.counterClick(ButtonTypeEnum.FIRST_BUTTON)
        }
        binding.btnTwo.setOnClickListener {
            presenter.counterClick(ButtonTypeEnum.SECOND_BUTTON)
        }
        binding.btnThree.setOnClickListener {
            presenter.counterClick(ButtonTypeEnum.THIRD_BUTTON)
        }
    }

    override fun setButtonText(model: ButtonUiModel) {
        when (model.index) {
            ButtonTypeEnum.FIRST_BUTTON -> binding.btnOne.text = model.value
            ButtonTypeEnum.SECOND_BUTTON -> binding.btnTwo.text = model.value
            ButtonTypeEnum.THIRD_BUTTON -> binding.btnThree.text = model.value
        }
    }

    companion object {
        fun newInstance(): CounterFragment = CounterFragment()
    }
}