package com.example.matule.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object SignIn

    @Serializable
    object Home
}