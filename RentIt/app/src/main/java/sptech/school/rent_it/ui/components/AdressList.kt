package sptech.school.rent_it.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Label
import androidx.compose.material.icons.filled.Map
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
//import sptech.school.rent_it.data.models.adresses
import sptech.school.rent_it.data.models.userItems
import sptech.school.rent_it.ui.screen.UserViewModel

@Composable
fun AdressList(
    viewModel: UserViewModel,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.padding(8.dp))

//    LazyColumn(modifier = modifier) {
//        items(adresses) { item ->
//            Spacer(modifier = Modifier.padding(8.dp))
//            AdressCard(
//                bairro = item.bairro,
//                numero = item.numero,
//                cep = item.cep,
//                icon = Icons.Filled.Map,
//                adress = item
//            )
//        }
//    }
}

@Composable
fun ItemList(
    viewModel: UserViewModel,
    modifier: Modifier = Modifier
) {
    val userItems by viewModel.userItems.observeAsState(emptyList())

    Spacer(modifier = Modifier.padding(8.dp))

    LazyColumn(modifier = modifier) {
        items(userItems) { item ->
            Spacer(modifier = Modifier.padding(8.dp))
            ItemCard(
                title= item.nome!!,
                icon = Icons.Filled.Label,
                item = item
            )
        }
    }
}