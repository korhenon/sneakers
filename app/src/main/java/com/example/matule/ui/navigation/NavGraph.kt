package com.example.matule.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.matule.ui.screens.onboard.OnboardScreen
import com.example.matule.ui.screens.splash.SplashScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destinations.Splash,
        modifier = modifier
    ) {
        composable<Destinations.Splash> {
            SplashScreen(navController)
        }
        composable<Destinations.Onboard> {
            OnboardScreen(navController)
        }
        composable<Destinations.Home> {

        }
    }
}