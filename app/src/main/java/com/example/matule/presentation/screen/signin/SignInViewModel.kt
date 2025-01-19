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
    private val _signInErrorModals = MutableStateFlow(SignInErrorModals())
    private val _isLoading = MutableStateFlow(false)

    val email get() = _email
    val password get() = _password
    val signInErrorModals get() = _signInErrorModals
    val isLoading get() = _isLoading

    fun onEmailChange(value: String) {
        _email.value = value
    }

    fun onPasswordChange(value: String) {
        _password.value = value
    }

    fun closeNotEmailValid() {
        _signInErrorModals.value = _signInErrorModals.value.copy(showNotEmailValid = false)
    }

    fun closeNotPasswordValid() {
        _signInErrorModals.value = _signInErrorModals.value.copy(showNotPasswordValid = false)
    }

    fun closeAuthenticationFail() {
        _signInErrorModals.value = _signInErrorModals.value.copy(showAuthenticationFail = false)
    }

    fun signIn(navController: NavController) {
        val isEmailValid = _email.value.isValidEmail()
        val isPasswordValid = _password.value.isPasswordValid()
        if (isEmailValid && isPasswordValid) {
            viewModelScope.launch {
                _isLoading.value = true
                val result = repository.signIn(_email.value, _password.value)
                _isLoading.value = false
                _signInErrorModals.value = SignInErrorModals(
                    showNotEmailValid = false, showNotPasswordValid = false,
                    showAuthenticationFail = !result
                )
                if (result) {
                    navController.navigate(Destinations.Home)
                }
            }
        } else {
            _signInErrorModals.value = SignInErrorModals(
                !isEmailValid, !isPasswordValid, showAuthenticationFail = true
            )
        }
    }
}