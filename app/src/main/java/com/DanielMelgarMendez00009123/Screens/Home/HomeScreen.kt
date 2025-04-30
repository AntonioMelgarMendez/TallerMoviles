package com.DanielMelgarMendez00009123.Screens.Home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.DanielMelgarMendez00009123.components.RestaurantCard
import com.DanielMelgarMendez00009123.data.dummyRestaurants

@Composable
fun HomeScreen(navController: NavHostController) {
    dummyRestaurants.forEach {
        Log.d("HomeScreen", "Restaurante: ${it.name}, categorías: ${it.categories}")
    }

    val groupedRestaurants = try {
        dummyRestaurants.groupBy { it.categories.firstOrNull() ?: "Otros" }
    } catch (e: Exception) {
        Log.e("HomeScreen", "Error agrupando restaurantes", e)
        emptyMap()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(bottom = 56.dp)

    ) {
        groupedRestaurants.forEach { (category, restaurants) ->
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = category,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        contentPadding = PaddingValues(vertical = 8.dp)
                    ) {
                        items(
                            items = restaurants,
                            key = { it.id }
                        ) { restaurant ->
                            RestaurantCard(
                                restaurant = restaurant,
                                navController = navController,
                                onRestaurantClick = {
                                    navController.currentBackStackEntry?.savedStateHandle?.set(
                                        "restaurant",
                                        restaurant
                                    )
                                    navController.navigate("menu_screen")
                                },
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(260.dp)
                                    .padding(horizontal = 8.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
