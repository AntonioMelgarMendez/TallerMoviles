package com.DanielMelgarMendez00009123.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.DanielMelgarMendez00009123.Screens.Home.HomeScreen
import com.DanielMelgarMendez00009123.ui.MenuScreen
import com.DanielMelgarMendez00009123.ui.OrdersScreen
import com.DanielMelgarMendez00009123.ui.SearchScreen

@Composable
fun MainNavigation(navController: NavHostController) {
    val onRestaurantClick = { restaurantName: String ->
        navController.navigate(MenuScreenNavigation(restaurantName))
    }

    NavHost(
        navController = navController,
        startDestination = HomeScreenNavigation
    ) {
        composable<HomeScreenNavigation> {
            HomeScreen(
                navController = navController,

            )
        }

        composable<SearchScreenNavigation> {
            SearchScreen(navController)
        }

        composable<OrdersScreenNavigation> {
            OrdersScreen(navController)
        }

        composable<MenuScreenNavigation> { backStackEntry ->
            val restaurantName = backStackEntry.arguments?.getString("restaurantName") ?: ""
            MenuScreen(restaurantName = restaurantName, navController = navController)
        }
    }
}