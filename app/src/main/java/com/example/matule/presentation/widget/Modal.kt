package com.example.matule.presentation.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.matule.presentation.theme.Shadow

@Composable
fun Modal(text: String, onCloseRequest: () -> Unit, modifier: Modifier = Modifier) {
    val backgroundInteractionSource = remember { MutableInteractionSource() }
    val modalInteractionSource = remember { MutableInteractionSource() }

    Box(
        Modifier
            .fillMaxSize()
            .background(Shadow)
            .clickable(
                interactionSource = backgroundInteractionSource,
                indication = null
            ) { onCloseRequest() }, contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .background(colorScheme.background, RoundedCornerShape(20.dp))
                .padding(20.dp)
                .clickable(interactionSource = modalInteractionSource, indication = null) { }
        ) {
            Text(text = text)
        }
    }
}