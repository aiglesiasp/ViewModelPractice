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

            stateLiveData.observe(this@MainActivity) {
                when(it) {
                    is MainActivityViewModel.MainActivityState.Success -> {
                        binding.tvTitle2.text = it.num.toString()
                    }
                    is MainActivityViewModel.MainActivityState.Error -> {
                        binding.tvTitle2.text = it.message
                    }
                }
            }
        }
    }

    private fun setListeners() {
        with(binding) {
            tvTitle.setOnClickListener {
                viewModel.cambiarNumeroLiveData()
            }
            tvTitle2.setOnClickListener {
                viewModel.cambiarEstate()
            }
        }
    }
}