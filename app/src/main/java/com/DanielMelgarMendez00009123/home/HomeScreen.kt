package com.DanielMelgarMendez00009123.home
import RestaurantViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.DanielMelgarMendez00009123.data.Restaurant
import coil.compose.AsyncImage
import androidx.compose.material3.MaterialTheme



// HomeScreen.kt
@Composable
fun HomeScreen(
    viewModel: RestaurantViewModel,
    onRestaurantClick: (Int) -> Unit
) {
    val restaurants by viewModel.restaurants.collectAsState()
    val categories = restaurants.flatMap { it.categories }.distinct()

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            categories.forEach { category ->
                item {
                    CategorySection(
                        category = category,
                        restaurants = restaurants.filter { it.categories.contains(category) },
                        onRestaurantClick = onRestaurantClick
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

// CategorySection.kt
@Composable
fun CategorySection(
    category: String,
    restaurants: List<Restaurant>,
    onRestaurantClick: (Int) -> Unit
) {
    Column {
        Text(
            text = category,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        LazyRow {
            items(restaurants) { restaurant ->
                RestaurantItem(
                    restaurant = restaurant,
                    onClick = { onRestaurantClick(restaurant.id) }
                )
            }
        }
    }
}

// RestaurantItem.kt
@Composable
fun RestaurantItem(
    restaurant: Restaurant,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .padding(8.dp)
            .clickable(onClick = onClick),

    ) {
        Column {
            AsyncImage(
                model = restaurant.imageUrl,
                contentDescription = restaurant.name,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = restaurant.name,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}