package com.laboratorios.tienda.model

data class Producto(
    val id: Int,
    val name: String,
    val category: String,
    val price: Double,
    val description: String,
    val imageUrl: String,
    var addedToCart: Boolean = false
)