package sptech.school.rent_it.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sptech.school.rent_it.data.models.Item
import sptech.school.rent_it.ui.screen.ProductViewModel

@Composable
fun CardList(
    products: List<Item>,
    viewModel: ProductViewModel,
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(products) { product ->
            Spacer(modifier = Modifier.padding(16.dp))
            ProductCard(
//                painter = painterResource(id = R.drawable.avatar_2),
                product = product,
                viewModel = viewModel,
                isSelected = product.id == product?.id,
                navigateToDetail = navigateToDetail
            )
        }
    }
}