package com.example.matule.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object SignIn

    @Serializable
    object Home

    @Serializable
    object Onboard

    @Serializable
    object Splash

    @Serializable
    object Popular

    @Serializable
    data class Catalog(
        val category: String
    )

    @Serializable
    object Favorites
}