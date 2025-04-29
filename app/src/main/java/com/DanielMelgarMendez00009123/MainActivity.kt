package com.DanielMelgarMendez00009123

import RestaurantViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.DanielMelgarMendez00009123.navigation.Navigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = RestaurantViewModel()

        setContent {
            val navController = rememberNavController()
            Navigation(navController = navController, viewModel = viewModel)
        }
    }
}


