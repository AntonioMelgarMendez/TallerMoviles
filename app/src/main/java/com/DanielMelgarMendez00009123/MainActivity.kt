package com.DanielMelgarMendez00009123

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.DanielMelgarMendez00009123.ui.layout.MainAppScaffold
import com.DanielMelgarMendez00009123.ui.theme.FoodSpotByAgarciaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FoodSpotByAgarciaTheme {
                MainAppScaffold()
            }
        }
    }
}