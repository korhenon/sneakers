package com.example.matule.presentation.screen.catalog

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.toRoute
import com.example.matule.data.models.Product
import com.example.matule.domain.CatalogRepository
import com.example.matule.presentation.navigation.Destinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: CatalogRepository
): ViewModel() {
    private val _startCategory = savedStateHandle.toRoute<Destinations.Catalog>().category
    private val _selectedCategory = MutableStateFlow("")
    private val _products = MutableStateFlow(listOf<Product>())
    private val _categories = MutableStateFlow(listOf<String>())

    val selectedCategory get() = _selectedCategory
    val products get() = _products
    val categories get() = _categories

    init {
        viewModelScope.launch {
            _categories.value = repository.getCategories()
        }
        select(_startCategory)
    }

    fun select(category: String) {
        viewModelScope.launch {
            _selectedCategory.value = category
            _products.value = repository.getProductsByCategory(category)
        }
    }
}