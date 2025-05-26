package com.laboratorios.tienda.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.laboratorios.tienda.viewmodel.ProductoViewModel
import kotlinx.coroutines.launch

@Composable
fun ProductDetailScreen(navController: NavController, viewModel: ProductoViewModel, productId: Int) {
    val product = viewModel.getProductById(productId)
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    product?.let {
        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(it.imageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth().height(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(it.name, style = MaterialTheme.typography.headlineSmall)
                Text("${it.category} - $${it.price}")
                Spacer(modifier = Modifier.height(8.dp))
                Text(it.description)
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if (!it.addedToCart) {
                            viewModel.addToCart(it.id)
                            scope.launch {
                                snackbarHostState.showSnackbar("Producto agregado al carrito")
                            }
                        }
                    },
                    enabled = !it.addedToCart
                ) {
                    Text(if (it.addedToCart) "Ya en el carrito" else "Agregar al carrito")
                }
            }
        }
    }
}
