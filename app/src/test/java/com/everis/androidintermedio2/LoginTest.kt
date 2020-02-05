package com.everis.androidintermedio2

import com.example.data2.GetElementRepository
import com.example.domain2.DoLogin
import org.junit.Assert.assertEquals
import org.junit.Test

class LoginTest {
    private val repository = GetElementRepository()
    private val doLogin = DoLogin(repository)
    @Test
    fun loginTest() {
        val result = doLogin.invoke()
        assertEquals(
            true,
            result
        )
    }
}