package com.aiglesiaspubill.viewmodelpractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivityViewModel: ViewModel() {

    var num = Random.nextInt()

    val numLiveData : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val stateLiveData : MutableLiveData<MainActivityState> by lazy {
        MutableLiveData<MainActivityState>()
    }


    //LLAMADA A LA API
    fun cambiarNumero() {
        num = Random.nextInt()
    }

    fun cambiarNumeroLiveData() {
        numLiveData.value = Random.nextInt()
    }

    fun cambiarEstate() {
        //Si el numero e spositvo estado SUCCESS
        //Si el numero es negativo el estado devuelve un ERROR

        stateLiveData.value = MainActivityState.Loading

        var num = Random.nextInt()
        if(num>=0) {
            stateLiveData.value = MainActivityState.Success(num)
        }
        else {
            stateLiveData.value = MainActivityState.Error("Ha ocurrido un error")
        }
    }

    sealed class MainActivityState {
        data class Success(val num: Int) : MainActivityState()
        data class Error(val message: String) : MainActivityState()
        object Loading : MainActivityState()
    }
}

