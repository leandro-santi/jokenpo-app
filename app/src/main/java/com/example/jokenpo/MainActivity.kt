package com.example.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jokenpo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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

    private fun evaluateRound(choice: String) {

        val result: String
        val iaOptions = listOf("Stone", "Paper", "Scissor")
        val opponentChoice = iaOptions.random()

        changeOpponentImageChoice(opponentChoice)

        result = when {
            (choice == opponentChoice) -> "Draw!"
            (choice == "Stone" && opponentChoice == "Scissor") ||
                    (choice == "Paper" && opponentChoice == "Stone") ||
                    (choice == "Scissor" && opponentChoice == "Paper") -> "You Won!"

            else -> "You Lose!"
        }

        binding.tvResult.text = result

    }

    private fun changeOpponentImageChoice(choice: String) {

        when (choice) {
            "Stone" -> binding.imOpponentOption.setImageResource(R.drawable.stone)
            "Paper" -> binding.imOpponentOption.setImageResource(R.drawable.paper)
            "Scissor" -> binding.imOpponentOption.setImageResource(R.drawable.scissor)
        }

    }

}