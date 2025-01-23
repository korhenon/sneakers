package com.example.matule.presentation.screen.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.matule.R
import com.example.matule.presentation.theme.MatuleTheme
import com.example.matule.presentation.theme.Shadow
import com.example.matule.presentation.theme.poppins
import com.example.matule.presentation.theme.raleway
import com.example.matule.presentation.widget.MaxWidthButton
import com.example.matule.presentation.widget.Modal

@Composable
fun SignInScreen(navController: NavController, viewModel: SignInViewModel = hiltViewModel()) {
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val signInErrorModals by viewModel.signInErrorModals.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    var isPasswordShowing by rememberSaveable { mutableStateOf(false) }

    Scaffold(containerColor = colorScheme.surface, bottomBar = {
        Text(
            text = buildAnnotatedString {
                append("Вы впервые? ")
                withStyle(SpanStyle(color = colorScheme.onBackground)) {
                    append("Создать пользователя")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 47.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontFamily = raleway,
            fontSize = 16.sp,
            color = colorScheme.onSurfaceVariant
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(78.dp))
            Text(
                text = "Привет!",
                fontFamily = raleway,
                color = colorScheme.onBackground,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Заполните Свои Данные Или\nПродолжите Через Социальные Медиа",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontFamily = poppins,
                color = colorScheme.outline
            )
            Spacer(Modifier.height(30.dp))
            Text(
                text = "Email",
                Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Medium,
                fontFamily = raleway,
                color = colorScheme.onBackground,
                fontSize = 16.sp
            )
            Spacer(Modifier.height(12.dp))
            TextField(
                value = email,
                onValueChange = viewModel::onEmailChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("email"),
                shape = RoundedCornerShape(14.dp),
                placeholder = {
                    Text(
                        "xyz@gmail.com",
                        color = colorScheme.onSurfaceVariant,
                        fontFamily = poppins,
                        fontWeight = FontWeight.Medium
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = colorScheme.background,
                    focusedContainerColor = colorScheme.background,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(Modifier.height(30.dp))
            Text(
                text = "Пароль",
                Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Medium,
                fontFamily = raleway,
                color = colorScheme.onBackground,
                fontSize = 16.sp
            )
            Spacer(Modifier.height(12.dp))
            TextField(
                value = password,
                onValueChange = viewModel::onPasswordChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("password"),
                shape = RoundedCornerShape(14.dp),
                placeholder = {
                    Row(horizontalArrangement = Arrangement.spacedBy(3.dp)) {
                        repeat(8) {
                            Box(
                                Modifier
                                    .size(6.dp)
                                    .background(colorScheme.onSurfaceVariant, CircleShape)
                            )
                        }
                    }
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = colorScheme.background,
                    focusedContainerColor = colorScheme.background,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                trailingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.eye),
                        contentDescription = "",
                        tint = colorScheme.onSurfaceVariant,
                        modifier = Modifier.clickable {
                            isPasswordShowing = !isPasswordShowing
                        }
                    )
                },
                visualTransformation = if (isPasswordShowing) VisualTransformation.None else PasswordVisualTransformation()
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = "Восстановить",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
                color = colorScheme.outline,
                fontFamily = poppins,
                fontSize = 12.sp
            )
            Spacer(Modifier.height(24.dp))
            MaxWidthButton(
                "Войти",
                { viewModel.signIn(navController) },
                modifier = Modifier.testTag("sign_in")
            )
        }
    }
    if (signInErrorModals.showNotEmailValid) {
        Modal(
            text = "Почта не соответсвует формату",
            onCloseRequest = viewModel::closeNotEmailValid,
            modifier = Modifier.testTag("not_valid_email_modal")
        )
    }
    if (signInErrorModals.showNotPasswordValid) {
        Modal(
            text = "Пароль не соответсвует формату",
            onCloseRequest = viewModel::closeNotPasswordValid,
            modifier = Modifier.testTag("not_valid_password_modal")
        )
    }
    if (signInErrorModals.showAuthenticationFail) {
        Modal(
            text = "Не успешная авторизация",
            onCloseRequest = viewModel::closeAuthenticationFail,
            modifier = Modifier.testTag("authorization_failed")
        )
    }
    if (isLoading) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Shadow), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    MatuleTheme {
        SignInScreen(rememberNavController())
    }
}