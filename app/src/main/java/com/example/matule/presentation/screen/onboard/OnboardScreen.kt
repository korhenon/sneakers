package com.example.matule.presentation.screen.onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.matule.R
import com.example.matule.presentation.navigation.Destinations
import com.example.matule.presentation.theme.MatuleTheme
import com.example.matule.presentation.widget.MaxWidthButton

@Composable
fun OnboardScreen(navController: NavHostController, viewModel: OnboardViewModel = hiltViewModel()) {
    val page by viewModel.page.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        colorScheme.primary,
                        colorScheme.inversePrimary
                    )
                )
            )
    ) {
        when (page) {
            1 -> {
                OnboardPage1()
            }

            2 -> {
                OnboardPage23(
                    image = {
                        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                            val (image, line1, line2) = createRefs()
                            Image(
                                painter = painterResource(id = R.drawable.onboard2),
                                contentDescription = "",
                                modifier = Modifier.constrainAs(image) {
                                    width = Dimension.fillToConstraints
                                }
                            )
                            Image(
                                painter = painterResource(R.drawable.onboard1_line4),
                                contentDescription = "",
                                modifier = Modifier
                                    .constrainAs(line1) {
                                        top.linkTo(image.top, margin = 36.dp)
                                    }
                                    .alpha(0.8f)
                            )
                            Image(
                                painter = painterResource(R.drawable.onboard1_line3),
                                contentDescription = "",
                                modifier = Modifier
                                    .constrainAs(line2) {
                                        top.linkTo(image.top, margin = 33.dp)
                                        end.linkTo(image.end, margin = 26.dp)
                                    }
                                    .alpha(0.7f)
                            )
                        }
                    },
                    title = "Начнем\nпутешествие",
                    text = "Умная, великолепная и модная коллекция Изучите сейчас",
                    page = page
                )
            }

            else -> {
                OnboardPage23(
                    image = {
                        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                            val (image, line) = createRefs()
                            Image(
                                painter = painterResource(R.drawable.onboard3),
                                contentDescription = "",
                                modifier = Modifier.constrainAs(image) {
                                    width = Dimension.fillToConstraints
                                }
                            )
                            Image(
                                painter = painterResource(R.drawable.onboard1_line3),
                                contentDescription = "",
                                modifier = Modifier
                                    .constrainAs(line) {
                                        top.linkTo(image.top, margin = 28.dp)
                                        start.linkTo(image.start, margin = 52.dp)
                                    }
                                    .size(77.dp)
                                    .alpha(0.7f)
                            )
                        }
                    },
                    title = "У вас есть сила, чтобы",
                    text = "В вашей комнате много красивых и привлекательных растений",
                    page = page
                )
            }
        }
    }
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, bottom = 36.dp)
    ) {
        MaxWidthButton(
            text = if (page == 1) "Начать" else "Далее",
            onClick = {
                if (page < 3) viewModel.next()
                else navController.navigate(Destinations.Home) {
                    popUpTo<Destinations.Onboard> {
                        inclusive = true
                    }
                }
            },
            contentColor = colorScheme.onSurface,
            containerColor = colorScheme.surface
        )
    }
}

@Preview
@Composable
private fun OnboardScreenPreview() {
    MatuleTheme {
        OnboardScreen(rememberNavController())
    }
}