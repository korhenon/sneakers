package com.example.matule.data.network

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.providers.builtin.Email
import javax.inject.Inject

class AuthorizationService @Inject constructor(
    private val auth: Auth
) {
    suspend fun signIn(email: String, password: String) {
        auth.signInWith(Email) {
            this.email = email
            this.password = password
        }
    }

    fun checkLoggedIn(): Boolean {
        return auth.currentUserOrNull() != null
    }
}