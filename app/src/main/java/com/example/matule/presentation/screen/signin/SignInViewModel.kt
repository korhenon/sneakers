package com.example.matule.presentation.screen.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.matule.common.isPasswordValid
import com.example.matule.common.isValidEmail
import com.example.matule.domain.AuthorizationRepository
import com.example.matule.presentation.navigation.Destinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: AuthorizationRepository
) : ViewModel() {
    private val _email = MutableStateFlow("")
    private val _password = MutableStateFlow("")
    private val _signResult = MutableStateFlow(
        SignInResult(
            isEmailValid = true,
            isPasswordValid = true,
            isAuthenticationSuccess = true
        )
    )
    val email get() = _email
    val password get() = _password
    val signInResult get() = _signResult

    fun onEmailChange(value: String) {
        _email.value = value
    }

    fun onPasswordChange(value: String) {
        _password.value = value
    }

    fun clearSignInResult() {
        _signResult.value = SignInResult(
            isEmailValid = true,
            isPasswordValid = true,
            isAuthenticationSuccess = true
        )
    }

    fun signIn(navController: NavController) {
        val isEmailValid = _email.value.isValidEmail()
        val isPasswordValid = _password.value.isPasswordValid()
        if (isEmailValid && isPasswordValid) {
            viewModelScope.launch {
                _signResult.value = SignInResult(
                    isEmailValid = true, isPasswordValid = true,
                    repository.signIn(_email.value, _password.value)
                )
                if (_signResult.value.isAuthenticationSuccess) {
                    navController.navigate(Destinations.Home)
                }
            }
        } else {
            _signResult.value = SignInResult(
                isEmailValid, isPasswordValid
            )
        }
    }
}