package com.example.matule

import com.example.matule.common.isPasswordValid
import com.example.matule.common.isValidEmail
import org.junit.Test

class ValidatorsTest {
    @Test
    fun isEmailValid_isCorrect() {
        assert("mail@mail.com".isValidEmail())
    }

    @Test
    fun isPasswordValid_isCorrect() {
        assert("Qw123%rty".isPasswordValid())
    }
}
