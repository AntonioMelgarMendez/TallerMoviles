package com.DanielMelgarMendez00009123.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeScreenNavigation

@Serializable
object SearchScreenNavigation

@Serializable
object OrdersScreenNavigation

@Serializable
data class MenuScreenNavigation(val restaurantName: String)