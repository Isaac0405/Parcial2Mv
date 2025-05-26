package com.laboratorios.tienda.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.laboratorios.tienda.ui.screens.*
import com.laboratorios.tienda.viewmodel.ProductoViewModel

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    val viewModel: ProductoViewModel = viewModel()
    NavHost(navController, startDestination = "list") {
        composable("list") { ProductListScreen(navController, viewModel) }
        composable("detail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull() ?: 0
            ProductDetailScreen(navController, viewModel, productId)
        }
        composable("cart") { CartScreen(navController, viewModel) }
    }
}
