package com.DanielMelgarMendez00009123.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.DanielMelgarMendez00009123.Screens.Home.HomeScreen
import com.DanielMelgarMendez00009123.data.dummyRestaurants
import com.DanielMelgarMendez00009123.Screens.DetailViewRestaurant.MenuScreen
import com.DanielMelgarMendez00009123.ui.OrdersScreen
import com.DanielMelgarMendez00009123.ui.SearchScreen
import kotlinx.coroutines.launch

object Routes {
    const val HOME = "home"
    const val SEARCH = "search"
    const val ORDERS = "orders"
    const val RESTAURANT_DETAIL = "restaurant/{restaurantId}"

    fun restaurantDetail(restaurantId: Int) = "restaurant/$restaurantId"
}

data class NavItem(val label: String, val icon: ImageVector, val route: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScaffold() {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route?.split('?')?.first()

    val destinations = listOf(
        NavItem("Restaurantes", Icons.Default.Home, Routes.HOME),
        NavItem("Buscar", Icons.Default.Search, Routes.SEARCH),
        NavItem("Mis Pedidos", Icons.Default.ShoppingCart, Routes.ORDERS),
    )

    val currentTitle = when (currentRoute?.split('/')?.first()) {
        Routes.HOME -> "Restaurantes"
        Routes.SEARCH -> "Buscar Restaurantes"
        Routes.ORDERS -> "Mis Pedidos"
        "restaurant" -> "Menú"
        else -> "Mi App"
    }

    val showBackButton = currentRoute != Routes.HOME

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(currentTitle, style = MaterialTheme.typography.headlineSmall) },
                navigationIcon = {
                    if (showBackButton) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Volver"
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ) {
                destinations.forEach { destination ->
                    NavigationBarItem(
                        icon = { Icon(destination.icon, contentDescription = destination.label) },
                        label = { Text(destination.label) },
                        selected = currentRoute == destination.route,
                        onClick = {
                            navController.navigate(destination.route) {
                                launchSingleTop = true
                                if (destination.route == Routes.HOME) {
                                    popUpTo(Routes.HOME) { inclusive = false }
                                }
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            indicatorColor = MaterialTheme.colorScheme.surface
                        )
                    )
                }
            }
        },
        floatingActionButton = {
            if (currentRoute == Routes.HOME) {
                FloatingActionButton(
                    onClick = {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Acción principal",
                                duration = SnackbarDuration.Short
                            )
                        }
                    },
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Acción principal")
                }
            }
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = Routes.HOME,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(Routes.HOME) { HomeScreen(navController) }
                composable(Routes.SEARCH) { SearchScreen(navController) }
                composable(Routes.ORDERS) { OrdersScreen(navController) }
                composable(Routes.RESTAURANT_DETAIL) { backStackEntry ->
                    val restaurantId = backStackEntry.arguments?.getString("restaurantId")?.toIntOrNull()
                    val restaurant = dummyRestaurants.find { it.id == restaurantId }

                    if (restaurant != null) {
                        MenuScreen(
                            navController = navController,
                            restaurant = restaurant,
                            onAddToCart = { dishName ->
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "$dishName agregado al carrito",
                                        duration = SnackbarDuration.Short
                                    )
                                }
                            }
                        )
                    } else {
                        Text("Restaurante no encontrado")
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainAppScaffoldPreview() {
    MaterialTheme {
        MainAppScaffold()
    }
}