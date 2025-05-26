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
fun ProductListScreen(navController: NavController, viewModel: ProductoViewModel) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = viewModel.searchQuery,
            onValueChange = viewModel::onSearchQueryChange,
            label = { Text("Buscar producto") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate("cart") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Carrito")
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(viewModel.filteredProducts) { product ->
                ProductosCard(product = product) {
                    navController.navigate("detail/${product.id}")
                }
            }
        }
    }
}
