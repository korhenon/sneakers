package com.example.matule.presentation.screen.onboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OnboardIndicator(page: Int, modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = modifier) {
        repeat(3) {
            if (it == (page - 1)) {
                Box(
                    Modifier
                        .height(5.dp)
                        .width(44.dp)
                        .background(colorScheme.onPrimary, shape = CircleShape)
                )
            } else {
                Box(
                    Modifier
                        .height(5.dp)
                        .width(28.dp)
                        .background(colorScheme.onPrimaryContainer, shape = CircleShape)
                )
            }
        }
    }
}