package sptech.school.rent_it.ui.screens.searchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import sptech.school.rent_it.R
import sptech.school.rent_it.ui.components.CardList
import sptech.school.rent_it.ui.components.Input
import sptech.school.rent_it.ui.screen.ProductViewModel
import sptech.school.rent_it.ui.theme.shapes
import sptech.school.rent_it.ui.theme.typography

@Composable
fun SearchScreen(
    viewModel: ProductViewModel,
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val itemInfos by viewModel.itemSelected.observeAsState()
    val items by viewModel.itemSearched.observeAsState(emptyList())
    var itemName by remember { mutableStateOf(itemInfos?.nomeItem ?: "") }


    Column(
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(
                    shape = shapes.medium,
                    color = MaterialTheme.colorScheme.surfaceTint
                )
                .padding(16.dp)
        ) {
            Input(
                label = "Buscar",
                labelColor = MaterialTheme.colorScheme.onSecondary,
                labelStyle = typography.headlineSmall,
                value = itemName,
                onValueChange = { newText ->
                    itemName = newText
                    viewModel.getProductByNome(newText)
                },
                imeAction = ImeAction.Done,
                keyBoardType = KeyboardType.Text,
                placeholder = {
                    Text(
                        text = "O que está procurando hoje?",
                        style = typography.bodyMedium,
                        color = MaterialTheme.colorScheme.outline
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(R.string.buscar)
                    )
                }
            )
        }
        CardList(
            products = items,
            viewModel = viewModel,
            navigateToDetail = navigateToDetail,
        )
    }
}

//@Preview(showBackground = true)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun SearchScreenDarkPreview() {
//    RentItTheme {
//        SearchScreen(
//            navController = rememberNavController(),
//            navigateToDetail = {}
//        )
//    }
//}