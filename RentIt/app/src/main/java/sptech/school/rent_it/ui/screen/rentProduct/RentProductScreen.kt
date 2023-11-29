package sptech.school.rent_it.ui.screens.rentProductScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import sptech.school.rent_it.R
import sptech.school.rent_it.data.models.CompleteItem
import sptech.school.rent_it.ui.components.Avatar
import sptech.school.rent_it.ui.screen.ProductViewModel
import sptech.school.rent_it.ui.theme.typography
import sptech.school.rent_it.utils.categories
import java.text.NumberFormat

@Composable
fun RentProductScreen(
//    painter: Painter,
    itemSelected: CompleteItem?,
    viewModel: ProductViewModel,
//    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
//            .verticalScroll(rememberScrollState())
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
            Text(
                text = itemSelected!!.nomeItem.toString(),
                style = typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = modifier
                    .padding(horizontal = 16.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = categories[itemSelected.categoria!!].toString(),
                    style = typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )
                Text(
                    text = NumberFormat.getCurrencyInstance().format(itemSelected.valorDia),
                    style = typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
//                    .fillMaxSize()
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
                    modifier = Modifier
                ) {
                    Text(
                        text = itemSelected.nomeUsuario!!.toString(),
                        style = typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = itemSelected.telefone.toString(),
                        style = typography.titleSmall,
                        color = MaterialTheme.colorScheme.outline
                    )
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
                    text = stringResource(R.string.forma_de_pagamento),
                    style = typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                )

//                CreditCardList()

                Spacer(modifier = Modifier.padding(32.dp))
            }
        }

    }
}

data class PagamentoItem(
    val id: String = "",
    val idCartao: String = "",
    val cpfTitular: String = "",
    val idUsuario: String = "",
    val dtInicio: String = "",
    val dtFim: String = "",
)










