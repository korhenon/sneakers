package com.example.matule.presentation.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.matule.presentation.theme.raleway

@Composable
fun SplashScreen(navController: NavHostController, viewModel: SplashViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.launch(navController)
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