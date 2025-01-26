package com.example.matule.domain

import com.example.matule.data.local.SharedPreferencesService
import javax.inject.Inject

class OnboardRepository @Inject constructor(
    private val sharedPreferencesService: SharedPreferencesService
) {
    val lastVisitPage get() = sharedPreferencesService.lastPageVisit

    fun next() {
        sharedPreferencesService.lastPageVisit += 1
    }
}