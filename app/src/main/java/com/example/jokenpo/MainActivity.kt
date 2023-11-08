package com.example.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.jokenpo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()

    }

    private fun setListeners() {

        binding.imStone.setOnClickListener {
            evaluateRound("Stone")
        }

        binding.imPaper.setOnClickListener {
            evaluateRound("Paper")
        }

        binding.imScissor.setOnClickListener {
            evaluateRound("Scissor")
        }

    }

    private fun evaluateRound(choice: String){

        val result: String = "$choice!"

        binding.tvResult.text = result

    }

}