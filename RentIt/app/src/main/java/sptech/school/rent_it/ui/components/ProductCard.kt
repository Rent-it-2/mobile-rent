package sptech.school.rent_it.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import sptech.school.rent_it.data.models.Item
import sptech.school.rent_it.ui.screen.ProductViewModel
import sptech.school.rent_it.ui.theme.shapes
import sptech.school.rent_it.ui.theme.typography
import sptech.school.rent_it.utils.categories
import java.text.NumberFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCard(
//    painter: Painter,
    viewModel: ProductViewModel,
    product: Item,
    isSelected: Boolean = false,
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        shape = shapes.large,
        modifier = modifier
            .padding(horizontal = 16.dp)
            .semantics { selected = isSelected }
            .width(350.dp),
        onClick = {
            navigateToDetail(product.id!!)
        }
    ) {
        Column(
            modifier = Modifier
        ) {
//            Box(modifier = Modifier.fillMaxWidth()) {
//                Image(
//                    painter = painterResource(id = R.drawable.avatar_2),
//                    contentDescription = stringResource(R.string.imagem_do_produto),
//                    alignment = Alignment.Center,
//                    contentScale = ContentScale.FillWidth,
//                    modifier = Modifier
//                        .width(350.dp)
//                        .height(200.dp)
////                        .fillMaxWidth()
//                )
//            }

            Column(
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = product.nome!!,
                    style = typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = categories[product.categoria!!].toString(),
                        style = typography.titleSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = NumberFormat.getCurrencyInstance().format(product.valDia),
                        style = typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ProductScreenLightPreview() {
//    RentItTheme {
//        ProductCard(
//            product =
//            ProductUiState(
//                id = "1",
//                nome = "Furadeira de Luxo",
//                categoria = 2,
//                descricao = "\"\"\"Thought we might be able to go over some details about our upcoming vacation. I've been doing a bit of research and have come across a few paces in Northern Brazil that I think we should check out. One, the north has some of the most predictable wind on the planet. I'd love to get out on the ocean and kitesurf for a couple of days if we're going to be anywhere near or around Taiba. I hear it's beautiful there and if you're up for it, I'd love to go. Other than that, I haven't spent too much time looking into places along our road trip route. I'm assuming we can find places to stay and things to do as we drive and find places we think look interesting. But... I know you're more of a planner, so if you have ideas or places in mind, lets jot some ideas down! Maybe we can jump on the phone later today if you have a second.\"\"\",\n",
//                valDia = 34.0,
//                user = users.get(1)
//            ),
//            painter = painterResource(id = R.drawable.ic_launcher_background),
////            navController = rememberNavController()
//            navigateToDetail = {}
//
//        )
//    }
//}

//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun ProductScreenDarkPreview() {
//    RentItTheme {
//        ProductCard(
//            product =
//            ProductUiState(
//                id = "1",
//                nome = "Furadeira de Luxo",
//                categoria = 2,
//                descricao = "\"\"\"Thought we might be able to go over some details about our upcoming vacation. I've been doing a bit of research and have come across a few paces in Northern Brazil that I think we should check out. One, the north has some of the most predictable wind on the planet. I'd love to get out on the ocean and kitesurf for a couple of days if we're going to be anywhere near or around Taiba. I hear it's beautiful there and if you're up for it, I'd love to go. Other than that, I haven't spent too much time looking into places along our road trip route. I'm assuming we can find places to stay and things to do as we drive and find places we think look interesting. But... I know you're more of a planner, so if you have ideas or places in mind, lets jot some ideas down! Maybe we can jump on the phone later today if you have a second.\"\"\",\n",
//                valDia = 34.0,
//                user = users.get(1)
//            ),
//            painter = painterResource(id = R.drawable.ic_launcher_background),
////            navController = rememberNavController()
//            navigateToDetail = {}
//        )
//    }
//}