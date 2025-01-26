package com.example.matule.presentation.screen.onboard

import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.matule.R
import com.example.matule.presentation.theme.MatuleTheme
import com.example.matule.presentation.theme.raleway

@Composable
fun OnboardPage1() {
    ConstraintLayout() {
        val (welcome, image, indicator, line1, line2, line3, line4, line5) = createRefs()
        Text(
            text = "ДОБРО\nПОЖАЛОВАТЬ!",
            textAlign = TextAlign.Center,
            fontFamily = raleway,
            fontWeight = FontWeight.Black,
            color = colorScheme.onPrimary,
            fontSize = 30.sp,
            modifier = Modifier.constrainAs(welcome) {
                centerHorizontallyTo(parent)
                top.linkTo(parent.top, margin = 28.dp)
            },
            lineHeight = 30.sp
        )
        Image(
            painter = painterResource(id = R.drawable.onboard1_line1),
            contentDescription = "",
            modifier = Modifier.constrainAs(line1) {
                bottom.linkTo(welcome.bottom, margin = 28.dp)
                end.linkTo(welcome.start, margin = (-4).dp)
            })
        Image(
            painter = painterResource(id = R.drawable.onboard1_line2),
            contentDescription = "",
            modifier = Modifier.constrainAs(line2) {
                top.linkTo(welcome.bottom, margin = 10.dp)
                centerHorizontallyTo(parent)
            }
        )
        Image(
            painter = painterResource(id = R.drawable.onboard1),
            contentDescription = "",
            modifier = Modifier.constrainAs(image) {
                top.linkTo(line2.bottom, margin = 80.dp)
                width = Dimension.matchParent
            }
        )
        OnboardIndicator(1, Modifier.constrainAs(indicator) {
            centerHorizontallyTo(parent)
            top.linkTo(image.bottom, margin = 40.dp)
        })
        Image(
            painter = painterResource(id = R.drawable.onboard1_line3),
            contentDescription = "",
            modifier = Modifier.constrainAs(line3) {
                top.linkTo(image.top, margin = 68.dp)
                start.linkTo(parent.start, margin = 44.dp)
            }.alpha(0.4f)
        )
        Image(
            painter = painterResource(R.drawable.onboard1_line4),
            contentDescription = "",
            modifier = Modifier.constrainAs(line4) {
                top.linkTo(image.bottom)
                end.linkTo(parent.end, margin = 30.dp)
            }.alpha(0.4f)
        )
        Image(
            painter = painterResource(id = R.drawable.onboard1_line5),
            contentDescription = "",
            modifier = Modifier.constrainAs(line5) {
                top.linkTo(image.bottom, margin = 63.dp)
                start.linkTo(parent.start, margin = 30.dp)
            }.alpha(0.4f)
        )
    }
}

@Preview
@Composable
private fun OnboardPage1Preview() {
    MatuleTheme {
        OnboardPage1()
    }
}