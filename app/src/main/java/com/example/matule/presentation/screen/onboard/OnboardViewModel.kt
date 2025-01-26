package com.example.matule.presentation.screen.onboard

import androidx.lifecycle.ViewModel
import com.example.matule.data.local.SharedPreferencesService
import com.example.matule.domain.OnboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class OnboardViewModel @Inject constructor(
    private val repository: OnboardRepository
): ViewModel() {
    private val _page = MutableStateFlow(repository.lastVisitPage)

    val page get() = _page

    fun next() {
        repository.next()
        _page.value = repository.lastVisitPage
    }
}