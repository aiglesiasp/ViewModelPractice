package com.aiglesiaspubill.viewmodelpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
                        binding.progressBar.visibility = View.INVISIBLE
                    }
                    is MainActivityViewModel.MainActivityState.Error -> {
                        binding.tvTitle2.text = it.message
                        binding.progressBar.visibility = View.INVISIBLE
                    }
                    is MainActivityViewModel.MainActivityState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
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
            btnNext.setOnClickListener {
                //TODO: Llamar a la funcion cambiar de layout del boton
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }
}