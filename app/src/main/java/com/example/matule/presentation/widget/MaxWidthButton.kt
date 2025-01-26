package com.example.matule.presentation.widget

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.presentation.theme.raleway

@Composable
fun MaxWidthButton(
    text: String,
    onClick: () -> Unit,
    contentColor: Color = colorScheme.onPrimary,
    containerColor: Color = colorScheme.primary,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = contentColor,
            containerColor = containerColor
        ),
        contentPadding = PaddingValues(vertical = 14.dp)
    ) {
        Text(
            text = text,
            fontFamily = raleway,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            lineHeight = 22.sp,
        )
    }
}