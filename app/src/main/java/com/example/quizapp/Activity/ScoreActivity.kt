package com.example.quizapp.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityScoreBinding
import com.example.quizapp.databinding.ViewholderLeaderBinding

class ScoreActivity : AppCompatActivity() {
    lateinit var binding: ActivityScoreBinding
    var score :Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        score= intent.getIntExtra("Score",0)
        binding.apply {
            scoreText.text=score.toString()
            backToMainBtn.setOnClickListener {
                startActivity(Intent(this@ScoreActivity, MainActivity::class.java))
                finish()
            }
        }

    }
}