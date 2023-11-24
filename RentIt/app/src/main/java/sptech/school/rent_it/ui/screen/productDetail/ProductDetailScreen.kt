package sptech.school.rent_it.ui.screens.productDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sptech.school.rent_it.R
import sptech.school.rent_it.data.models.CompleteItem
import sptech.school.rent_it.ui.components.Avatar
import sptech.school.rent_it.ui.screen.ProductViewModel
import sptech.school.rent_it.ui.theme.typography
import sptech.school.rent_it.utils.categories
import java.text.NumberFormat

@Composable
fun ProductDetailScreen(
//    painter: Painter,
//    itemSelected: Item?,
    itemSelected: CompleteItem?,
    viewModelProduct: ProductViewModel,
//    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
//    val itemSelected by viewModelProduct.itemSelected.observeAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {
//        OutlinedCard(
//            shape = shapes.large,
//            modifier = Modifier.padding(16.dp)
//        ) {
//            Image(
//                painter = painter,
//                contentDescription = stringResource(R.string.imagem_do_produto),
//                alignment = Alignment.Center,
//                contentScale = ContentScale.FillWidth,
//                modifier = Modifier
//                    .fillMaxWidth()
//            )
//        }

        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
//            itemSelected?.let {
                Text(
                    text = itemSelected!!.nomeItem.toString(),
                    style = typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                )
//            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
//                if (itemSelected != null) {
                Text(
                    text = categories[itemSelected!!.categoria!!].toString(),
                    style = typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )
//                }
//                if (itemSelected != null) {
                    Text(
                        text = NumberFormat.getCurrencyInstance().format(itemSelected!!.valorDia),
                        style = typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
//                }
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Avatar(
                    drawableResource = R.drawable.avatar_9,
                    description = "User",
                    modifier = Modifier.size(60.dp),
                    onClick = {}
                )
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxHeight()
                ) {
//                    if (itemSelected != null) {
                    itemSelected!!.nomeUsuario?.let {
                        Text(
                            text = it,
                            style = typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
//                    }
//                    if (itemSelected != null) {
                    Text(
                        text = itemSelected!!.telefone.toString(),
                        style = typography.titleSmall,
                        color = MaterialTheme.colorScheme.outline
                    )
//                    }
                }
                IconButton(onClick = { "Tdod" }) {
                    Icon(
                        imageVector = Icons.Filled.Chat,
                        contentDescription = "Voltar",
                    )
                }
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Descrição",
                    style = typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                )

//                if (itemSelected != null) {
                Text(
                    text = itemSelected!!.descricao.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
//                }

                Spacer(modifier = Modifier.padding(32.dp))

            }
        }

    }
}

//@Preview(showBackground = true)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun ProductDetailScreenDarkPreview() {
//    RentItTheme {
//        ProductDetailScreen(
//            painterResource(id = R.drawable.avatar_2),
//            itemSelected =
//            Item(
//                id = "1",
//                nome = "Furadeira de Luxo",
//                categoria = 1,
//                descricao = "Thought we might be able to go over some details about our upcoming vacation. I've been doing a bit of research and have come across a few paces in Northern Brazil that I think we should check out. One, the north has some of the most predictable wind on the planet. I'd love to get out on the ocean and kitesurf for a couple of days if we're going to be anywhere near or around Taiba. I hear it's beautiful there and if you're up for it, I'd love to go. Other than that, I haven't spent too much time looking into places along our road trip route. I'm assuming we can find places to stay and things to do as we drive and find places we think look interesting. But... I know you're more of a planner, so if you have ideas or places in mind, lets jot some ideas down! Maybe we can jump on the phone later today if you have a second.,\n",
//                valDia = 34.0,
//                usuario = users.get(1)
//            ),
//            navController = rememberNavController()
//        )
//    }
//}