package sptech.school.rent_it.ui.screen.product

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import sptech.school.rent_it.data.models.Item
import sptech.school.rent_it.ui.components.CardList
import sptech.school.rent_it.ui.screen.ProductViewModel

@Composable
fun ProductScreen(
    navController: NavHostController,
    navigateToDetail: (Int) -> Unit,
    viewModel: ProductViewModel,
    products: List<Item>,
    modifier: Modifier = Modifier,
) {
    CardList(
        products = products,
        navigateToDetail = navigateToDetail,
        viewModel = viewModel,
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun ProductScreenDarkPreview() {
//    RentItTheme {
//        ProductScreen(
//            products = products,
//            navController = rememberNavController(),
//            navigateToDetail = {}
//        )
//    }
//}