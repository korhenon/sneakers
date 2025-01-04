package com.example.matule.ui.navigation

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object Splash

    @Serializable
    object Onboard

    @Serializable
    object Home
}