
package com.DanielMelgarMendez00009123.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun OrdersScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Pantalla de órdenes", style = MaterialTheme.typography.headlineSmall)
    }
}
