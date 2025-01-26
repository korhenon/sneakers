package com.example.matule.presentation.screen.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matule.data.models.Product
import com.example.matule.domain.CatalogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(
    private val repository: CatalogRepository
): ViewModel() {
    private val _popular = MutableStateFlow(listOf<Product>())

    val popular get() = _popular

    init {
        viewModelScope.launch {
            _popular.value = repository.getPopular()
        }
    }
}