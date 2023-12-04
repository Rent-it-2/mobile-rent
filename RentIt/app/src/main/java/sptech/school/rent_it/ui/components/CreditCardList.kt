package sptech.school.rent_it.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sptech.school.rent_it.ui.screen.UserViewModel

@Composable
fun CreditCardList(
    viewModel: UserViewModel,
    modifier: Modifier = Modifier
) {
    val userCards by viewModel.userCartoes.observeAsState(emptyList())
    Spacer(modifier = Modifier.padding(8.dp))

    LazyColumn(modifier = modifier) {
        items(userCards) { card ->
            Spacer(modifier = Modifier.padding(8.dp))
            CardCreditCard(
                title = card.nomeUsuario!!,
                icon = Icons.Filled.CreditCard,
                creditCard= card
            )
        }
    }
}