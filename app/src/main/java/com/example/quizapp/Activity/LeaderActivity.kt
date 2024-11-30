package com.example.quizapp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.quizapp.Adapter.LeaderAdapter
import com.example.quizapp.Domain.userModel
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityLeaderBinding

class LeaderActivity : AppCompatActivity() {
    lateinit var binding : ActivityLeaderBinding
    private val leaderAdapter by lazy { LeaderAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLeaderBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val window :Window =this@LeaderActivity.window
        window.statusBarColor =ContextCompat.getColor(this@LeaderActivity,R.color.grey)

        binding.apply {
            top1point.text = loadData().get(0).score.toString()
            top2point.text = loadData().get(1).score.toString()
            top3point.text = loadData().get(2).score.toString()
            title1.text = loadData().get(0).name
            title2.text = loadData().get(1).name
            title3.text = loadData().get(2).name

            val drawableResourceId1: Int =binding.root.resources.getIdentifier(
                loadData().get(0).pic,"drawable",binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId1)
                .into(pic1)

            val drawableResourceId2: Int =binding.root.resources.getIdentifier(
                loadData().get(1).pic,"drawable",binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId2)
                .into(pic2)

            val drawableResourceId3: Int =binding.root.resources.getIdentifier(
                loadData().get(2).pic,"drawable",binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId3)
                .into(pic3)

            menu.setItemSelected(R.id.board)
            menu.setOnItemSelectedListener {
                if(it==R.id.home){
                   startActivity(Intent(this@LeaderActivity,MainActivity::class.java))
                }
            }
            var list :MutableList<userModel> = loadData()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)
            leaderAdapter.differ.submitList(list)

            leaderView.apply {
                layoutManager = LinearLayoutManager(this@LeaderActivity)
                adapter = leaderAdapter
            }


        }

    }

    

    private fun loadData():MutableList<userModel>{
        val users: MutableList<userModel> = mutableListOf()
        users.add(userModel(1,"Danial","person1",2222))
        users.add(userModel(1,"Sho","person2",2100))
        users.add(userModel(3,"Rohit","person3",2000))
        users.add(userModel(3,"Shyam","person4",1888))
        users.add(userModel(5,"Wood","person5",1777))
        users.add(userModel(6,"Joe Root","person6",1666))
        users.add(userModel(3,"Bunty","person4",1555))
        users.add(userModel(5,"Alex","person5",1444))
        users.add(userModel(6,"Joseph","person6",1333))
        return users
    }
}