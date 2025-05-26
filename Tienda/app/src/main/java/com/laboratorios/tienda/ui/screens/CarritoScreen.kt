package com.laboratorios.tienda.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.laboratorios.tienda.viewmodel.ProductoViewModel
import com.laboratorios.tienda.ui.components.ProductosCard

@Composable
fun CartScreen(navController: NavController, viewModel: ProductoViewModel) {
    val cartItems = viewModel.getCartItems()
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Carrito de Compras", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        if (cartItems.isEmpty()) {
            Text("No hay productos en el carrito.")
        } else {
            LazyColumn {
                items(cartItems) { producto ->
                    ProductosCard(product = producto, onClick = {})
                }
            }
        }
    }
}
