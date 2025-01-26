package com.example.matule.data.models

import com.example.matule.R
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Float,
    val image: String,
    val category: String
)
