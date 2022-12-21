package com.aiglesiaspubill.viewmodelpractice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aiglesiaspubill.viewmodelpractice.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    companion object {
        private const val TAG_TEXT = "TAG_TEXT"
        fun launch (context: Context, text: String) {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra(TAG_TEXT, text)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getStringExtra(TAG_TEXT)
        binding.tvTitle3.text = result
    }
}