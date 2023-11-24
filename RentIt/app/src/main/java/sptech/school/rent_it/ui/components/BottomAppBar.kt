package sptech.school.rent_it.ui.components

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import sptech.school.rent_it.R
import sptech.school.rent_it.ui.screens.NavigationViewModel

import sptech.school.rent_it.ui.theme.RentItTheme
import sptech.school.rent_it.utils.Routes

@Composable
fun BottomBar(
    viewModel: NavigationViewModel = viewModel(),
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    val uiState by viewModel.uiState.collectAsState()

    var selectedDestination by rememberSaveable { mutableStateOf(0) }

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        DESTINATIONS.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = uiState.currentPage == item.route,
                onClick = {
                    selectedDestination = index
                    viewModel.navigateToPage(
                        page = item.route,
                        navController = navController
                    )
                },
                label = { Text(text = stringResource(id = item.title)) },
                icon = {
                    Icon(
                        imageVector = if (selectedDestination == index) item.selectedIcon else item.unselectedIcon,
                        contentDescription = stringResource(id = item.iconTextId)
                    )
                }
            )
        }

    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BottomBarDarkPreview() {
    RentItTheme {
        BottomBar(
            navController = rememberNavController()
        )
    }
}

data class Destination(
    val title: Int,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int
)

val DESTINATIONS = listOf(
    Destination(
        title = R.string.inicio,
        route = Routes.PRODUCT_SCREEN,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        iconTextId = R.string.inicio
    ),
    Destination(
        title = R.string.buscar,
        route = Routes.SEARCH_SCREEN,
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search,
        iconTextId = R.string.buscar
    ),
    Destination(
        title = R.string.perfil,
        route = Routes.PROFILE_SCREEN,
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        iconTextId = R.string.perfil
    )
)