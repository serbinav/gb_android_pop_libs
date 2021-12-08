package com.example.popularlibs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.popularlibs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val counters = mutableListOf(0, 0, 0)
    private val COUNTERS_KEY = "COUNTERS_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOne.setOnClickListener {
            binding.btnOne.text = (++counters[0]).toString()
        }

        binding.btnTwo.setOnClickListener {
            binding.btnTwo.text = (++counters[1]).toString()
        }

        binding.btnThree.setOnClickListener {
            binding.btnThree.text = (++counters[2]).toString()
        }

        init()
    }

    fun init(){
        binding.btnOne.text = counters[0].toString()
        binding.btnTwo.text = counters[1].toString()
        binding.btnThree.text = counters[2].toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray(COUNTERS_KEY, counters.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val countersArray = savedInstanceState.getIntArray(COUNTERS_KEY)
        countersArray?.toList()?.let {
            counters.clear()
            counters.addAll(it)
            init()
        }
    }
}