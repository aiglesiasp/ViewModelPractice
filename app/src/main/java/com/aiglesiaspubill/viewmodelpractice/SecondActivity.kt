package com.aiglesiaspubill.viewmodelpractice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aiglesiaspubill.viewmodelpractice.databinding.ActivitySecondBinding
import com.aiglesiaspubill.viewmodelpractice.model.Numbers
import com.google.gson.Gson

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    companion object {
        private const val TAG_TEXT = "TAG_TEXT"
        fun launch (context: Context, numbers: Numbers) {
            val intent = Intent(context, SecondActivity::class.java)
            val numbersInString = Gson().toJson(numbers)
            intent.putExtra(TAG_TEXT, numbersInString)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getStringExtra(TAG_TEXT)
        val numbers = Gson().fromJson(result, Numbers::class.java)
        binding.tvTitle3.text = "Los numeros son : ${numbers.num1} y ${numbers.num2}"
    }
}