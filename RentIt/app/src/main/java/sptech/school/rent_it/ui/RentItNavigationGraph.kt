package sptech.school.rent_it.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import sptech.school.rent_it.data.models.CompleteItem
import sptech.school.rent_it.data.models.Item
import sptech.school.rent_it.ui.screen.ProductViewModel
import sptech.school.rent_it.ui.screen.UserViewModel
import sptech.school.rent_it.ui.screen.product.ProductScreen
import sptech.school.rent_it.ui.screens.login.LoginScreen
import sptech.school.rent_it.ui.screens.productDetail.ProductDetailScreen
import sptech.school.rent_it.ui.screens.profile.ProfileScreen
import sptech.school.rent_it.ui.screens.searchScreen.SearchScreen
import sptech.school.rent_it.utils.Routes

@Composable
fun RentItNavigationGraph(
    allProducts: List<Item>,
    itemSelected: CompleteItem?,
    viewModelUser: UserViewModel,
    viewModelProduct: ProductViewModel,
    navController: NavHostController,
    navigateToDetail: (Int) -> Unit
) {

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN_SCREEN,
    ) {
        composable(route = Routes.LOGIN_SCREEN) {
            LoginScreen(viewModel = viewModelUser, navController = navController)
        }
//        composable(route = Routes.RESGISTRATION_SCREEN) {
//            RegistrationScreen(
//                onNavigateLogin = {
//                    navController.navigate(Routes.LOGIN_SCREEN)
//                }
//            )
//        }
        composable(route = Routes.PRODUCT_SCREEN) {
            ProductScreen(
                navigateToDetail = navigateToDetail,
                navController = navController,
                products = allProducts,
                viewModel = viewModelProduct
            )
        }
        composable(route = Routes.PRODUCT_DETAIL_SCREEN) {
            ProductDetailScreen(
//                painter = painterResource(id = R.drawable.avatar_2),
                itemSelected = itemSelected,
                viewModelProduct = viewModelProduct,
            )
        }
//        composable(route = Routes.RENT_PRODUCT_SCREEN) {
//            RentProductScreen(
//                painter = painterResource(id = R.drawable.avatar_2),
//                uiState = productUIState,
//                navController = navController
//            )
//        }
        composable(route = Routes.SEARCH_SCREEN) {
            SearchScreen(
                navigateToDetail = navigateToDetail,
                viewModel = viewModelProduct
            )
        }
        composable(route = Routes.PROFILE_SCREEN) {
            ProfileScreen(
                viewModel = viewModelUser
            )
        }
    }
}