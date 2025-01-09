package com.example.matule.data.models

import com.example.matule.R

data class Product(
    val id: Int,
    val photo: Int = R.drawable.sneaker_example,
    val name: String = "Nike Air Max",
    val price: Float = 752f,
    val isFavorite: Boolean = false,
    val isInCart: Boolean = false
)
