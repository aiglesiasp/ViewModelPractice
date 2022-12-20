package com.aiglesiaspubill.viewmodelpractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityViewModel: ViewModel() {

    var num = Random.nextInt()

    val numLiveData : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    //LLAMADA A LA API
    fun cambiarNumero() {
        num = Random.nextInt()
    }

    fun cambiarNumeroLiveData() {
        numLiveData.value = Random.nextInt()
    }
}