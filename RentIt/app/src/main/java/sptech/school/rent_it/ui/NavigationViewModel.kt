
package sptech.school.rent_it.ui.screens

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import sptech.school.rent_it.utils.Routes

data class NavigationUiState(
//    val selectedDestination: Int = 0,
    val currentPage: String = Routes.PRODUCT_SCREEN,
)

class NavigationViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(NavigationUiState())
    val uiState: StateFlow<NavigationUiState> = _uiState.asStateFlow()

    fun setCurrentPage(route: String) {
        _uiState.update { currentState ->
            currentState.copy(
                currentPage = route,
            )
        }
    }

    fun navigateToPage(navController: NavHostController , page: String) {
        setCurrentPage(page)
        navController.navigate(page)
    }
}