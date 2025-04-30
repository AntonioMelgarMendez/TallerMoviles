import androidx.lifecycle.ViewModel
import com.DanielMelgarMendez00009123.data.Dish
import com.DanielMelgarMendez00009123.data.Restaurant
import com.DanielMelgarMendez00009123.data.dummyRestaurants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RestaurantViewModel : ViewModel() {
    private val _restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurants: StateFlow<List<Restaurant>> = _restaurants

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    init {
        _restaurants.value = dummyRestaurants
    }

    fun updateSearch(query: String) {
        _searchQuery.value = query
    }

    fun getFilteredDishes(restaurant: Restaurant): List<Dish> {
        return restaurant.menu.filter {
            it.name.contains(_searchQuery.value, ignoreCase = true)
        }
    }
}
