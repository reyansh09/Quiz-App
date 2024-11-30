package com.example.quizapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.Domain.QuestionModel
import com.example.quizapp.Domain.userModel
import com.example.quizapp.R
import com.example.quizapp.databinding.ViewholderLeaderBinding
import com.example.quizapp.databinding.ViewholderQuestionBinding

class QuestionAdapter(
    val correctAnswer: String,
    val users :MutableList<String> = mutableListOf(),
    var returnScore: score
):RecyclerView.Adapter<QuestionAdapter.ViewHolder>()
{
    interface score{
        fun amount(number: Int,clickedAnswer:String)
    }

    private lateinit var binding: ViewholderQuestionBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ViewholderQuestionBinding.inflate(inflater,parent,false)
        return ViewHolder()
    }

     override fun onBindViewHolder(holder: QuestionAdapter.ViewHolder, position: Int) {
       val binding = ViewholderQuestionBinding.bind(holder.itemView)
        binding.answerText.text = differ.currentList[position]
        var currectPos = 0
        when(correctAnswer){
            "a"->{
                currectPos = 0
            }
            "b"->{
                currectPos = 1
            }
            "c"->{
                currectPos = 2
            }
            "d"->{
                currectPos = 3
            }
        }
        if(differ.currentList.size == 5 && currectPos == position){
            binding.answerText.setBackgroundResource(R.drawable.green_bg)
            binding.answerText.setTextColor(
                ContextCompat.getColor(
                    binding.root.context,
                    R.color.white
                )
            )
            val drawable=ContextCompat.getDrawable(binding.root.context,R.drawable.tick)
            binding.answerText.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,drawable,null)
        }
        if(differ.currentList.size == 5){
            var clickedPos = 0
            when(differ.currentList[4]){
                "a"->{
                    clickedPos = 0
                }
                "b"->{
                    clickedPos = 1
                }
                "c"->{
                    clickedPos = 2
                }
                "d"->{
                    clickedPos = 3
                }
            }
            if(clickedPos  == position && clickedPos != currectPos){
                binding.answerText.setBackgroundResource(R.drawable.red_bg)
                binding.answerText.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.white
                    )
                )
                val drawable=ContextCompat.getDrawable(binding.root.context,R.drawable.thieves)
                binding.answerText.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,drawable,null)
            }
        }
        if(position==4){
            binding.root.visibility= View.GONE
        }
        holder.itemView.setOnClickListener{
            var str = ""
            when(position){
                0->{
                    str= "a"
                }
                1->{
                    str= "b"
                }
                2->{
                    str= "c"
                }
                3->{
                    str= "d"
                }
            }
            users.add(4,str)
            notifyDataSetChanged()

            if(currectPos==position){
                binding.answerText.setBackgroundResource(R.drawable.green_bg)
                binding.answerText.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.white
                    )
                )
                val drawable=ContextCompat.getDrawable(binding.root.context,R.drawable.tick)
                binding.answerText.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,drawable,null)
                returnScore.amount(5,str)
            }else{
                binding.answerText.setBackgroundResource(R.drawable.red_bg)
                binding.answerText.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.white
                    )
                )
                val drawable=ContextCompat.getDrawable(binding.root.context,R.drawable.thieves)
                binding.answerText.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,drawable,null)
                returnScore.amount(0,str)
            }
        }
        if (differ.currentList.size == 5 ) holder.itemView.setOnClickListener(null)
    }

    override fun getItemCount()= differ.currentList.size

    inner class ViewHolder: RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem
        }
    }
    val differ = AsyncListDiffer(this,differCallback)
}