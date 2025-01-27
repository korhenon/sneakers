package com.example.matule.domain

import com.example.matule.data.network.AuthorizationService
import javax.inject.Inject

class AuthorizationRepository @Inject constructor(
    private val service: AuthorizationService
) {
    suspend fun signIn(email: String, password: String): Boolean {
        try {
            service.signIn(email, password)
            return service.checkLoggedIn()
        } catch (e: Exception) {
            return false
        }
    }
}