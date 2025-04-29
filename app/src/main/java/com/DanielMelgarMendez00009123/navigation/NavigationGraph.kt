package com.DanielMelgarMendez00009123.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.DanielMelgarMendez00009123.home.HomeScreen
import com.DanielMelgarMendez00009123.restaurant.RestaurantScreen
import RestaurantViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: RestaurantViewModel
) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                viewModel = viewModel,
                onRestaurantClick = { restaurantId ->
                    navController.navigate("restaurant/$restaurantId")
                }
            )
        }

        composable("restaurant/{restaurantId}") { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getString("restaurantId")?.toIntOrNull()
            if (restaurantId != null) {
                RestaurantScreen(
                    restaurantId = restaurantId,
                    viewModel = viewModel,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}
