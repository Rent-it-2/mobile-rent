package sptech.school.rent_it.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import sptech.school.rent_it.data.models.CompleteItem
import sptech.school.rent_it.data.models.Item
import sptech.school.rent_it.ui.screen.ProductViewModel
import sptech.school.rent_it.ui.screen.UserViewModel
import sptech.school.rent_it.ui.screen.login.LoginScreen
import sptech.school.rent_it.ui.screen.product.ProductScreen
import sptech.school.rent_it.ui.screen.registration.RegistrationScreen
import sptech.school.rent_it.ui.screen.search.SearchScreen
import sptech.school.rent_it.ui.screens.productDetail.ProductDetailScreen
import sptech.school.rent_it.ui.screens.profile.ProfileScreen
import sptech.school.rent_it.ui.screen.rentProduct.RentProductScreen
import sptech.school.rent_it.utils.Routes

@RequiresApi(Build.VERSION_CODES.O)
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
            LoginScreen(
                viewModel = viewModelUser,
                navController = navController
            )
        }
        composable(route = Routes.RESGISTRATION_SCREEN) {
            RegistrationScreen(
                viewModel = viewModelUser,
                navController = navController
            )
        }
        composable(route = Routes.PRODUCT_SCREEN) {
            viewModelProduct.getItems()
            ProductScreen(
                navigateToDetail = navigateToDetail,
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
        composable(route = Routes.RENT_PRODUCT_SCREEN) {
            viewModelUser.getUserCards()
            RentProductScreen(
//                painter = painterResource(id = R.drawable.avatar_2),
                itemSelected = itemSelected,
                viewModel = viewModelUser,
                navController = navController
            )
        }
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