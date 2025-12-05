package com.example.restaurantapp.model

data class MenuItem(
    val id: String,
    val name: String,
    val price: Double,
    val description: String,
    val imageUrl: String? = null,
    val category: String? = null,
    val imageResId: Int
)

