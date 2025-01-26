package com.example.matule.presentation.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.presentation.theme.poppins

@Composable
fun CategoryItem(text: String, onClick: (String) -> Unit, isSelected: Boolean = false) {
    Box(
        Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick(text) }) {
        Text(
            text = text,
            modifier = Modifier
                .background(
                    if (isSelected) colorScheme.primary else colorScheme.surface,
                    RoundedCornerShape(8.dp)
                )
                .padding(vertical = 12.dp, horizontal = 26.dp)
                .widthIn(min = 56.dp),
            color = if (isSelected) colorScheme.onPrimary else colorScheme.onBackground,
            textAlign = TextAlign.Center,
            fontFamily = poppins,
            fontSize = 12.sp,
            letterSpacing = 1.sp
        )
    }
}