package com.example.popularlibs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.popularlibs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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