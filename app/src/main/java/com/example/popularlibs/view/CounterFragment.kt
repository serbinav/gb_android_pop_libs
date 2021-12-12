package com.example.popularlibs.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popularlibs.*
import com.example.popularlibs.databinding.FragmentCounterBinding
import com.example.popularlibs.presenter.CounterPresenter

class CounterFragment : Fragment(), CounterView {

    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!
    private val presenter = CounterPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        when(model.index){
            ButtonTypeEnum.FIRST_BUTTON -> binding.btnOne.text = model.value
            ButtonTypeEnum.SECOND_BUTTON -> binding.btnTwo.text = model.value
            ButtonTypeEnum.THIRD_BUTTON -> binding.btnThree.text = model.value
        }
    }
}