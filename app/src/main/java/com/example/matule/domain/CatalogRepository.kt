package com.example.matule.domain

import com.example.matule.data.models.Product
import com.example.matule.data.network.CatalogService
import javax.inject.Inject

class CatalogRepository @Inject constructor(
    private val service: CatalogService
) {
    suspend fun getCategories(): List<String> {
        try {
            val categories = mutableListOf("Все")
            for (product in service.getAll()) {
                if (product.category !in categories) {
                    categories.add(product.category)
                }
            }
            return categories
        } catch (e: Exception) {
            return listOf()
        }
    }

    suspend fun getPopular(): List<Product> {
        try {
            return service.getAll().take(4)
        } catch (e: Exception) {
            return listOf()
        }
    }

    suspend fun getProductsByCategory(category: String): List<Product> {
        try {
            if (category == "Все") {
                return service.getAll()
            } else {
                val products = mutableListOf<Product>()
                for (product in service.getAll()) {
                    if (product.category == category) {
                        products.add(product)
                    }
                }
                return products
            }
        } catch (e: Exception) {
            return listOf()
        }

    }
}