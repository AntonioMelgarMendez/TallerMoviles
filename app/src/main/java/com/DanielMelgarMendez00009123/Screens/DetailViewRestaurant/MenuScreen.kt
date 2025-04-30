package com.DanielMelgarMendez00009123.Screens.DetailViewRestaurant

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import com.DanielMelgarMendez00009123.data.Restaurant
import com.DanielMelgarMendez00009123.data.Dish
import java.text.Normalizer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavHostController, restaurant: Restaurant, onAddToCart: (String) -> Unit ) {
    var searchQuery by remember { mutableStateOf("") }

    val filteredDishes = remember(searchQuery, restaurant.menu) {
        if (searchQuery.isBlank()) {
            restaurant.menu
        } else {
            val normalizedQuery = searchQuery
                .lowercase()
                .normalizeChars()

            restaurant.menu.filter { dish ->
                dish.name
                    .lowercase()
                    .normalizeChars()
                    .contains(normalizedQuery) ||
                        dish.description
                            .lowercase()
                            .normalizeChars()
                            .contains(normalizedQuery)
            }
        }
    }
    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(restaurant.imageUrl)
                        .build()
                ),
                contentDescription = restaurant.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Text(
                text = restaurant.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(16.dp)
            )
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                placeholder = { Text("Buscar platillos...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline
                )
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                items(filteredDishes) { dish ->
                    DishItem(
                        dish = dish,
                        onAddToCart = {
                            onAddToCart(dish.name)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun DishItem(
    dish: Dish,
    onAddToCart: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(dish.imageUrl)
                            .build()
                    ),
                    contentDescription = dish.name,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(MaterialTheme.shapes.small)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = dish.name,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = dish.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onAddToCart, // Usa directamente la función
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Agregar al carrito")
            }
        }
    }
}
fun String.normalizeChars(): String {
    val normalized = Normalizer.normalize(this, Normalizer.Form.NFD)
    return normalized.replace("[^\\p{ASCII}]".toRegex(), "")
}