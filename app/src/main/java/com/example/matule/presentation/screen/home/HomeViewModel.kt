package com.example.matule.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matule.data.models.Product
import com.example.matule.domain.CatalogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CatalogRepository
) : ViewModel() {
    private val _isLoading = MutableStateFlow(true)
    private val _categories = MutableStateFlow(listOf<String>())
    private val _popular = MutableStateFlow(listOf<Product>())

    val isLoading get() = _isLoading
    val categories get() = _categories
    val popular get() = _popular

    init {
        viewModelScope.launch {
            _categories.value = repository.getCategories()
            _popular.value = repository.getPopular()
            _isLoading.value = false
        }
    }
}