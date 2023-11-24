package sptech.school.rent_it.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import sptech.school.rent_it.data.models.CreditCard
import sptech.school.rent_it.ui.theme.typography
import androidx.compose.material3.ModalBottomSheet



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardCreditCard(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    creditCard: CreditCard,
) {
    var openSheet by remember { mutableStateOf(false) }

    OutlinedCard(
        onClick = { openSheet = true },
        modifier = modifier
    ) {
        ListItem(
            headlineContent = {
                Text(text = title)
            },
            supportingContent = {
                Text(
                    text = creditCard.cpfTitular,
                    style = typography.titleSmall,
                    color = MaterialTheme.colorScheme.outline
                )
            },
            leadingContent = {
                Icon(
                    imageVector = icon,
                    contentDescription = ""
                )
            }
        )
    }

    if (openSheet) {
        ModalBottomSheet(
            onDismissRequest = { openSheet = false }
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                Text(
                    text = "Cartão de Crédito",
                    style = typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )

                SheetInfos(
                    title = "Nome Impresso:",
                    text = creditCard.nomeImpresso
                )

                SheetInfos(
                    title = "Número do Cartão:",
                    text = creditCard.numCartao
                )

                SheetInfos(
                    title = "CPF do Titular:",
                    text = creditCard.cpfTitular
                )

                SheetInfos(
                    title = "Validde do Cartão:",
                    text = creditCard.validade
                )
                
                Spacer(modifier = Modifier.padding(32.dp))
            }

        }
    }
}