package com.example.matule.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.matule.presentation.screen.signin.SignInScreen


@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destinations.SignIn,
        modifier = modifier
    ) {
        composable<Destinations.SignIn> {
            SignInScreen(navController)
        }
        composable<Destinations.Home> {
            Box(Modifier.testTag("home_screen"))
        }
    }
}