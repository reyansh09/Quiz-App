package com.example.quizapp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapp.Domain.QuestionModel
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var binding:  ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val window : Window =this@MainActivity.window
        window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.grey)

        binding.apply {
            menu.setItemSelected(R.id.home)
            menu.setOnItemSelectedListener {
                if(it==R.id.board){
                    startActivity(Intent(this@MainActivity,LeaderActivity::class.java))
                }
            }
            singlePlayerBtn.setOnClickListener{
                val intent =Intent(this@MainActivity,QuestionActivity::class.java)
                intent.putParcelableArrayListExtra("list", ArrayList(questionList()))
                startActivity(intent)
            }
        }
    }

    private fun questionList(): MutableList<QuestionModel>{
        val question : MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(1, "Which planet is the largest in our planet?",
            "Earth",
            "Mars",
            "Neptune",
            "Jupiter",
            "d",
            5,
            "q_1",
            null))
        question.add(QuestionModel(2,
            "Which country is the largest country in the world by land area?",
            "Russia",
            "Canada",
            "United State",
            "China",
            "a",
            5,
            "q_2",
            null))
        question.add(QuestionModel(3,"Which of the following substance  is used as an anti-cancer in the medicine world?",
            "Cheese",
            "Lemon juice",
            "Cannabis",
            "Paspulam",
            "c",
            5,
            "q_3",
            null))
        question.add(QuestionModel(4,"Which moon in the earth's solar system has an atmosphere?",
            "Luna(moon)",
            "Phobos(Mar's moon)",
            "Venus, moon",
            "None of the above ",
            "d",
            5,
            "q_4",
            null))
        question.add(QuestionModel(5,"Which of the following symbol represent the chemical element with atomic number 6?",
            "O",
            "H",
            "N",
            "C",
            "a",
            5,
            "q_5",
            null))
        question.add(QuestionModel(6,"Who is credited with inventing theater as we know it today?",
            "Shakespeare",
            "Askhouri",
            "Arthur miller",
            "Ancient Greek",
            "d",
            5,
            "q_6",
            null))
        question.add(QuestionModel(7,"Which ocean is the largest ocean in the world?",
            "Pacific Ocean",
            "Atlantic Ocean ",
            "Indian Ocean",
            "Arctic Ocean ",
            "a",
            5,
            "q_7",
            null))
        question.add(QuestionModel(8,"Which religion are among the4 most practiced religion in the world?",
            "Islam, Christianity, Judaism",
            "Buddhism, Hinduism, Sikhism",
            "Taoism, Shintoism, Confucianism",
            "None of the above",
            "a",
            5,
            "q_8",
            null))
        question.add(QuestionModel(9,"In which continent are the most independent country in the world?",
            "Asia",
            "Europe",
            "Africa",
            "America",
            "c",
            5,
            "q_9",
            null))
        question.add(QuestionModel(10,"Which ocean has the greatest average depth?",
            "Pacific Ocean",
            "Atlantic Ocean ",
            "Indian Ocean",
            "Southern Ocean ",
            "d",
            5,
            "q_10",
            null))
        return question
    }
}