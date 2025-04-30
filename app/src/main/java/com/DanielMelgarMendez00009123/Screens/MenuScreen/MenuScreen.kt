
package com.DanielMelgarMendez00009123.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.rememberAsyncImagePainter
import com.DanielMelgarMendez00009123.data.dummyRestaurants

@Composable
fun MenuScreen(restaurantName: String,navController: NavHostController) {
    val restaurant = dummyRestaurants.find { it.name == restaurantName }
    val context = LocalContext.current
    var search by remember { mutableStateOf("") }

    restaurant?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(it.name, style = MaterialTheme.typography.headlineSmall)
            Text(it.description, style = MaterialTheme.typography.bodyMedium)

            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                label = { Text("Buscar platillo") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            )

            LazyColumn {
                items(it.menu.filter { dish -> dish.name.contains(search, true) }) { dish ->
                    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                        Row(modifier = Modifier.padding(8.dp)) {
                            Image(
                                painter = rememberAsyncImagePainter(dish.imageUrl),
                                contentDescription = null,
                                modifier = Modifier.size(80.dp)
                            )
                            Column(modifier = Modifier.padding(start = 8.dp)) {
                                Text(dish.name, style = MaterialTheme.typography.titleMedium)
                                Text(dish.description, style = MaterialTheme.typography.bodySmall)
                                Button(
                                    onClick = {
                                        Toast.makeText(context, "${dish.name} agregado al carrito", Toast.LENGTH_SHORT).show()
                                    },
                                    modifier = Modifier.padding(top = 4.dp)
                                ) {
                                    Text("Agregar al carrito")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
