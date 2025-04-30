package com.DanielMelgarMendez00009123.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavController) {
    val items = listOf("home", "search", "orders")
    val icons = listOf(Icons.Default.Home, Icons.Default.Search, Icons.Default.ShoppingCart)
    val titles = listOf("Restaurantes", "Buscar", "Órdenes")

    NavigationBar {
        val backStackEntry = navController.currentBackStackEntryAsState()
        val current = backStackEntry.value?.destination?.route

        items.forEachIndexed { index, route ->
            NavigationBarItem(
                selected = current == route,
                onClick = { navController.navigate(route) },
                icon = { Icon(icons[index], contentDescription = titles[index]) },
                label = { Text(titles[index]) }
            )
        }
    }
}
