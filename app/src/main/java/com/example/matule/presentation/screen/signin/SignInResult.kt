package com.example.matule.presentation.screen.signin

data class SignInResult(
    val isEmailValid: Boolean = false,
    val isPasswordValid: Boolean = false,
    val isAuthenticationSuccess: Boolean = false
)
