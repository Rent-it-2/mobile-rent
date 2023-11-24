package sptech.school.rent_it

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import sptech.school.rent_it.ui.RentItNavigationGraph
import sptech.school.rent_it.ui.components.BottomBar
import sptech.school.rent_it.ui.components.TopAppBar
import sptech.school.rent_it.ui.screen.ProductViewModel
import sptech.school.rent_it.ui.screen.UserViewModel
import sptech.school.rent_it.ui.theme.shapes
import sptech.school.rent_it.ui.theme.typography
import sptech.school.rent_it.utils.Routes

@Composable
fun RentItApp(
    modifier: Modifier = Modifier,
    viewModelProduct: ProductViewModel,
    viewModelUser: UserViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val items by viewModelProduct.itemsData.observeAsState(emptyList())
    val itemSelected by viewModelProduct.itemSelected.observeAsState()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentPage = backStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (
                currentPage != Routes.LOGIN_SCREEN &&
                currentPage != Routes.RESGISTRATION_SCREEN
            ) {
                TopAppBar(
                    navController = navController,
                    title = when (currentPage) {
                        Routes.PRODUCT_SCREEN -> stringResource(R.string.produtos)
                        Routes.SEARCH_SCREEN -> stringResource(R.string.buscar)
                        Routes.PROFILE_SCREEN -> stringResource(R.string.perfil)
                        else -> ""
                    },
                    canNavigateBack = currentPage == Routes.PRODUCT_DETAIL_SCREEN,
                    showClasses = currentPage == Routes.PRODUCT_SCREEN,
                    navigateUp = {
                        if (currentPage == Routes.PRODUCT_DETAIL_SCREEN)
                            navController.navigateUp()
                        else
                            navController.navigate(
                                Routes.SEARCH_SCREEN
                            )
                    }
                )
            }
        },
        bottomBar = {
            if (
                currentPage != Routes.LOGIN_SCREEN &&
                currentPage != Routes.RESGISTRATION_SCREEN
            ) {
                BottomBar(
                    navController = navController
                )
            }
        },
        floatingActionButton = {
            if (
                currentPage == Routes.PRODUCT_DETAIL_SCREEN
            ) {
                ExtendedFloatingActionButton(
                    text = {
                        Text(
                            text = stringResource(R.string.alugar),
                            style = typography.titleLarge,
                        )
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.CurrencyExchange,
                            contentDescription = "Alugar"
                        )
                    },
                    shape = shapes.extraLarge,
                    containerColor = MaterialTheme.colorScheme.primary,
                    onClick = { viewModelProduct.rentProduct(navController) },
                    modifier = Modifier.fillMaxWidth(fraction = 0.92F)
                )
            }
        },
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            RentItNavigationGraph(
                viewModelUser = viewModelUser,
                viewModelProduct = viewModelProduct,
                allProducts = items,
                itemSelected = itemSelected,
                navigateToDetail = { productId: Int ->
                    viewModelProduct.getProductById(id = productId, navController = navController)
                },
                navController = navController
            )
        }
    }

}

//@Preview(showBackground = true)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun RentItAppDarkPreview() {
//    RentItTheme {
//        RentItApp(
////            viewModelProduct = viewModel(),
//            navController = rememberNavController(),
//        )
//    }
//}