package com.example.matule.ui

import androidx.lifecycle.ViewModel
import com.example.matule.data.models.Product

class MainViewModel: ViewModel() {
    val productsByCategory = mutableMapOf<String, List<Product>>()
    val popular: List<Product>
    init {
        val outdoor = mutableListOf<Product>()
        val tennis = mutableListOf<Product>()
        val running = mutableListOf<Product>()
        val popularBuffer = mutableListOf<Product>()
        repeat(20) {
            outdoor.add(Product(it))
            tennis.add(Product(20 + it))
            running.add(Product(40 + it))
            popularBuffer.add(Product(2 * it))
            if (it == 1) {
                popularBuffer[it] = popularBuffer[it].copy(isInCart = true)
            }
        }
        productsByCategory["Outdoor"] = outdoor
        productsByCategory["Tennis"] = tennis
        productsByCategory["Running"] = running
        popular = popularBuffer
    }
}