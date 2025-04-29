package com.DanielMelgarMendez00009123.restaurant

import RestaurantViewModel
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.DanielMelgarMendez00009123.data.Dish
import com.DanielMelgarMendez00009123.data.Restaurant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantScreen(
    restaurantId: Int,
    viewModel: RestaurantViewModel,
    onBackClick: () -> Unit
) {
    val restaurants by viewModel.restaurants.collectAsState()
    val restaurant = restaurants.firstOrNull { it.id == restaurantId }
    val searchText by viewModel.searchText.collectAsState()

    if (restaurant == null) {
        onBackClick()
        return
    }

    Column(modifier = Modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(
            title = { Text(restaurant.name) },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )

        Text(
            text = restaurant.description,
            modifier = Modifier.padding(16.dp)
        )

        OutlinedTextField(
            value = searchText,
            onValueChange = { viewModel.onSearchTextChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text("Buscar platillo...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") }
        )

        MenuList(
            dishes = viewModel.filterMenu(restaurantId, searchText),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun MenuList(
    dishes: List<Dish>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(dishes) { dish ->
            DishItem(dish = dish)
        }
    }
}

@Composable
fun DishItem(dish: Dish) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = dish.imageUrl,
                contentDescription = dish.name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = dish.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = dish.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            IconButton(
                onClick = {
                    Toast.makeText(
                        context,
                        "${dish.name} agregado al carrito",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add to cart")
            }
        }
    }
}
