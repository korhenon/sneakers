package com.example.matule.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.matule.presentation.screen.catalog.CatalogScreen
import com.example.matule.presentation.screen.home.HomeScreen
import com.example.matule.presentation.screen.onboard.OnboardScreen
import com.example.matule.presentation.screen.popular.PopularScreen
import com.example.matule.presentation.screen.signin.SignInScreen
import com.example.matule.presentation.screen.splash.SplashScreen


@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destinations.Splash,
        modifier = modifier
    ) {
        composable<Destinations.SignIn> {
            SignInScreen(navController)
        }
        composable<Destinations.Home> {
            HomeScreen(navController)
        }
        composable<Destinations.Onboard> {
            OnboardScreen(navController)
        }
        composable<Destinations.Splash> {
            SplashScreen(navController)
        }
        composable<Destinations.Catalog> {
            CatalogScreen(navController)
        }
        composable<Destinations.Popular> {
            PopularScreen(navController)
        }
        composable<Destinations.Favorites> {  }
    }
}