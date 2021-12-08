package com.example.popularlibs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.popularlibs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val presenter = MainPresenter(this)
    private val COUNTERS_KEY = "COUNTERS_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOne.setOnClickListener {
            presenter.counterOneClick()
        }
        binding.btnTwo.setOnClickListener {
            presenter.counterTwoClick()
        }
        binding.btnThree.setOnClickListener {
            presenter.counterThreeClick()
        }
    }

    override fun setButtonOneText(text: String) {
        binding.btnOne.text = text
    }

    override fun setButtonTwoText(text: String) {
        binding.btnTwo.text = text
    }

    override fun setButtonThreeText(text: String) {
        binding.btnThree.text = text
    }
}