package com.aiglesiaspubill.viewmodelpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.aiglesiaspubill.viewmodelpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setObservers()
        setListeners()

    }

    private fun setObservers() {
        with(viewModel) {
            numLiveData.observe(this@MainActivity) {
                binding.tvTitle.text = it.toString()
            }
        }
    }

    private fun setListeners() {
        with(binding) {
            tvTitle.setOnClickListener {
                viewModel.cambiarNumeroLiveData()
            }
        }
    }
}