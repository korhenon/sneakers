package com.example.matule.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.matule.ui.navigation.Destinations
import com.example.matule.ui.theme.MatuleTheme
import com.example.matule.ui.theme.raleway
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavHostController) {
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        scope.launch {
            delay(500)
            navController.navigate(Destinations.Onboard) {
                popUpTo<Destinations.Splash>() {
                    inclusive = true
                }
            }
        }
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        colorScheme.primary,
                        colorScheme.inversePrimary
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buildAnnotatedString {
                append("MATULE ")
                withStyle(
                    SpanStyle(
                        baselineShift = BaselineShift.Superscript,
                        fontWeight = FontWeight.Light,
                        fontSize = 20.sp
                    )
                ) {
                    append("ME")
                }
            },
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
            color = colorScheme.onPrimary,
            fontFamily = raleway
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    MatuleTheme {
        SplashScreen(rememberNavController())
    }
}