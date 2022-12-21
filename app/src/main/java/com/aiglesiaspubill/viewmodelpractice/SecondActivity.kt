package com.aiglesiaspubill.viewmodelpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aiglesiaspubill.viewmodelpractice.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}