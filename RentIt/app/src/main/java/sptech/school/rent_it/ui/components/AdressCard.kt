package sptech.school.rent_it.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import sptech.school.rent_it.R
import sptech.school.rent_it.data.models.Adress
import sptech.school.rent_it.ui.theme.typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdressCard(
    modifier: Modifier = Modifier,
    bairro: String,
    numero: Int,
    cep: String,
    icon: ImageVector,
    adress: Adress
) {
    var openSheet by remember { mutableStateOf(false) }

    OutlinedCard(
        onClick = { openSheet = true },
        modifier = modifier
    ) {
        ListItem(
            headlineContent = {
                Text(
                    text = "$bairro, $numero",
                    style = typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
            supportingContent = {
                Text(
                    text = cep,
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
                    text = stringResource(R.string.endereco),
                    style = typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )

                SheetInfos(
                    title = stringResource(R.string.cep),
                    text = adress.cep
                )

                SheetInfos(
                    title = stringResource(R.string.cidade),
                    text = adress.cidade
                )

                SheetInfos(
                    title = stringResource(R.string.bairro),
                    text = adress.bairro
                )

                SheetInfos(
                    title = stringResource(R.string.logradouro),
                    text = adress.logradouro
                )

                SheetInfos(
                    title = stringResource(R.string.numero),
                    text = adress.numero.toString()
                )

                Spacer(modifier = Modifier.padding(32.dp))
            }

        }
    }
}