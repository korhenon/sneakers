package com.example.matule.presentation.screen.onboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.presentation.theme.poppins
import com.example.matule.presentation.theme.raleway

@Composable
fun OnboardPage23(image: @Composable () -> Unit, title: String, text: String, page: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(Modifier.height(36.dp))
        image()
        Spacer(Modifier.height(60.dp))
        Text(
            text = title,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = colorScheme.onPrimary,
            textAlign = TextAlign.Center,
            fontFamily = raleway,
            lineHeight = 44.sp,
            modifier = Modifier.padding(horizontal = 30.dp)
        )
        Spacer(Modifier.height(12.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            color = colorScheme.primaryContainer,
            fontFamily = poppins,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 30.dp)
        )
        Spacer(Modifier.height(40.dp))
        OnboardIndicator(page)
    }
}