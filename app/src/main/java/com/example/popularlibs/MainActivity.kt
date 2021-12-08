package com.example.popularlibs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.popularlibs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    val presenter = MainPresenter(this)
    private val COUNTERS_KEY = "COUNTERS_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listener = View.OnClickListener{
            presenter.counterClick(it.id)
        }
        binding.btnOne.setOnClickListener(listener)
        binding.btnTwo.setOnClickListener(listener)
        binding.btnThree.setOnClickListener(listener)
    }

    //error
    override fun setButtonText(index: Int, text: String) {
        when (index) {
            0 -> binding.btnOne.text = text
            1 -> binding.btnTwo.text = text
            2 -> binding.btnThree.text = text
        }
    }
}