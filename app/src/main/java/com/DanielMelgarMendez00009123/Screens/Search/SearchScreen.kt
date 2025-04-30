
package com.DanielMelgarMendez00009123.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.DanielMelgarMendez00009123.data.Restaurant
import com.DanielMelgarMendez00009123.data.dummyRestaurants
import com.DanielMelgarMendez00009123.ui.layout.Routes
import java.text.Normalizer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    fun String.normalizeForSearch(): String {
        return Normalizer.normalize(this.lowercase(), Normalizer.Form.NFD)
            .replace("[^a-z0-9 ]".toRegex(), "")
    }
    val filteredRestaurants = remember(searchQuery) {
        if (searchQuery.isBlank()) {
            emptyList()
        } else {
            val normalizedQuery = searchQuery.normalizeForSearch()
            dummyRestaurants.filter { restaurant ->
                // Busca en: nombre del restaurante, categorías o platillos
                restaurant.name.normalizeForSearch().contains(normalizedQuery) ||
                        restaurant.categories.any { it.normalizeForSearch().contains(normalizedQuery) } ||
                        restaurant.menu.any { it.name.normalizeForSearch().contains(normalizedQuery) }
            }
        }
    }

    Scaffold(
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            SearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            )
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(filteredRestaurants) { restaurant ->
                    RestaurantResultItem(
                        restaurant = restaurant,
                        onClick = { navController.navigate(Routes.restaurantDetail(restaurant.id)) }
                    )
                }
            }
        }
    }
}

@Composable
private fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier,
        placeholder = { Text("Buscar restaurantes, platillos...") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        shape = MaterialTheme.shapes.large
    )
}

@Composable
private fun RestaurantResultItem(
    restaurant: Restaurant,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(restaurant.name, style = MaterialTheme.typography.titleMedium)
            Text(restaurant.description, style = MaterialTheme.typography.bodySmall)
        }
    }
}