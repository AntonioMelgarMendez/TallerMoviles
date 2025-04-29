import androidx.lifecycle.ViewModel
import com.DanielMelgarMendez00009123.data.Dish
import com.DanielMelgarMendez00009123.data.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RestaurantViewModel : ViewModel() {
    private val _restaurants = MutableStateFlow(emptyList<Restaurant>())
    val restaurants: StateFlow<List<Restaurant>> = _restaurants.asStateFlow()

    private val _searchText = MutableStateFlow("")
    val searchText: StateFlow<String> = _searchText.asStateFlow()

    init {
        loadDummyData()
    }

    private fun loadDummyData() {

        _restaurants.value = listOf(
            Restaurant(
                id = 1,
                name = "Pizza Planet",
                description = "Las mejores pizzas del universo",
                imageUrl = "https://example.com/pizza.jpg",
                categories = listOf("Pizzas", "Comida Italiana", "Vegetariano"),
                menu = listOf(
                    Dish(
                        id = 1,
                        name = "Pizza Pepperoni",
                        description = "Clásica pizza con pepperoni y queso.",
                        imageUrl = "https://example.com/pepperoni.jpg"
                    ),
                    Dish(
                        id = 2,
                        name = "Pizza Vegetariana",
                        description = "Pizza saludable con verduras frescas.",
                        imageUrl = "https://example.com/veggie.jpg"
                    )
                )
            )

        )
    }

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun filterMenu(restaurantId: Int, query: String): List<Dish> {
        return _restaurants.value
            .firstOrNull { it.id == restaurantId }
            ?.menu
            ?.filter {
                it.name.contains(query, ignoreCase = true) ||
                        it.description.contains(query, ignoreCase = true)
            } ?: emptyList()
    }
}