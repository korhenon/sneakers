package com.example.matule.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.matule.domain.OnboardRepository
import com.example.matule.presentation.navigation.Destinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: OnboardRepository
) : ViewModel() {
    fun launch(navController: NavController) {
        viewModelScope.launch {
            delay(500)
            if (repository.lastVisitPage >= 3) {
                navController.navigate(Destinations.Home)
            }
            else {
                navController.navigate(Destinations.Onboard)
            }
        }
    }
}