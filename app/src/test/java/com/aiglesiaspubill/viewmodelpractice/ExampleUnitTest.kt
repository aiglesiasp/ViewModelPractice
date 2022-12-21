package com.aiglesiaspubill.viewmodelpractice

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    var viewModel = MainActivityViewModel()
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testGetNum() {
        var numInicial = viewModel.num
        viewModel.cambiarNumero()
        var numFin = viewModel.num
        assertNotEquals(numInicial, numFin)
    }
}