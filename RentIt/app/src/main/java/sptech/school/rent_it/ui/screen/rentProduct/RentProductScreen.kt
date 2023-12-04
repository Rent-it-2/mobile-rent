package sptech.school.rent_it.ui.screen.rentProduct

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Today
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import sptech.school.rent_it.R
import sptech.school.rent_it.data.models.CompleteItem
import sptech.school.rent_it.ui.components.Avatar
import sptech.school.rent_it.ui.components.Input
import sptech.school.rent_it.ui.screen.UserViewModel
import sptech.school.rent_it.ui.theme.typography
import sptech.school.rent_it.utils.categories
import java.net.URLEncoder
import java.text.NumberFormat
import java.time.LocalDate


//@RequiresApi(Build.VERSION_CODES.O)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RentProductScreen(
//    painter: Painter,
    itemSelected: CompleteItem?,
    viewModel: UserViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val userCards by viewModel.userCartoes.observeAsState(emptyList())
    var selectedValue by rememberSaveable { mutableStateOf(0) }
    var cpfValue by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    var dtInicioValue by rememberSaveable { mutableStateOf(LocalDate.now()) }
    var dtFimValue by rememberSaveable { mutableStateOf(LocalDate.now()) }
//    val formattedDtInicioValue by rememberSaveable {
//        derivedStateOf {
//            DateTimeFormatter
//                .ofPattern("dd-MM-yyyy")
//                .format(dtInicioValue)
//        }
//    }
//    val formattedDtFimValue by rememberSaveable {
//        derivedStateOf {
//            DateTimeFormatter
//                .ofPattern("dd/MM/yyyy")
//                .format(dtFimValue)
//        }
//    }

    fun calcularValorFinal(): String {
        val quantidadeDias = calcularDiasEntreDatas(dtInicioValue, dtFimValue)
        val valorFinal = quantidadeDias * itemSelected!!.valorDia!!
        return NumberFormat.getCurrencyInstance().format(valorFinal)
    }


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
            Text(
                text = itemSelected!!.nomeItem!!,
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
                    text = categories[itemSelected!!.categoria!!].toString(),
                    style = typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )
                Text(
                    text = NumberFormat.getCurrencyInstance().format(itemSelected!!.valorDia),
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
                        contentDescription = null,
                    )
                }
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Input(
                    label = stringResource(R.string.cpf),
                    value = cpfValue,
                    onValueChange = { newText ->
                        cpfValue = newText
                    },
                    imeAction = ImeAction.Done,
                    keyBoardType = KeyboardType.Number,
                    placeholder = {
                        Text(text = stringResource(R.string.digite_seu_cpf))
                    },
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(32.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    DatePickerButton("De", Icons.Default.Today, dtInicioValue) {
                        dtInicioValue = it
                    }

                    Text(
                        text = dtInicioValue.toString(),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    DatePickerButton("Até", Icons.Default.Event, dtFimValue) {
                        dtFimValue = it
                    }

                    Text(
                        text = dtFimValue.toString(),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground
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

                userCards.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                            selected = selectedValue == item.id,
                            onClick = {
                                selectedValue = item.id!!
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedValue == item.id,
                            onClick = {
                                selectedValue = item.id!!
                            }
                        )
                        Text(item.numCartao!!)
                    }
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
                    text = stringResource(R.string.total),
                    style = typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Text(
                    text = calcularValorFinal(),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    onClick = {
//                        viewModel.rentProduct(
//                            cartaoId = selectedValue,
//                            cpf = cpfValue,
//                            dtFim = dtFimValue.toString(),
//                            dtInicio = dtInicioValue.toString(),
//                            itemId = itemSelected.id!!,
//                            idUso = itemSelected.idUsuario!!,
//                            valorFinal = calcularValorFinal().toInt(),
//                            navController = navController
//                        )
                        openWhatsApp(itemSelected.telefone!!, context)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.finalizar),
                        fontSize = 16.sp
                    )
                }

            }
//            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun calcularDiasEntreDatas(dataInicio: LocalDate, dataFim: LocalDate): Long {
    return dataFim.toEpochDay() - dataInicio.toEpochDay()
}

//@SuppressLint("SuspiciousIndentation")
//fun openWhatsApp(phoneNumber: String, context: Context) {
//    val whatsappIntent = Intent(Intent.ACTION_VIEW)
//    val formattedPhoneNumber = phoneNumber.replace("+", "").replace(" ", "")
//    Log.d("Service error:", "WhatsApp $formattedPhoneNumber")
//    val uri = Uri.parse("whatsapp://send?phone=$formattedPhoneNumber")
//    whatsappIntent.data = uri
//        ContextCompat.startActivity(context, whatsappIntent, null)
//}


@SuppressLint("SuspiciousIndentation")
fun openWhatsApp(phoneNumber: String, context: Context) {
    // Remova espaços em branco do número
    val trimmedPhoneNumber = phoneNumber.replace(" ", "")

    // Adicione o prefixo "+1" se não estiver presente
    val formattedPhoneNumber = if (!trimmedPhoneNumber.startsWith("+1")) {
        "+1$trimmedPhoneNumber"
    } else {
        trimmedPhoneNumber
    }

    Log.d("Service error:", "WhatsApp $formattedPhoneNumber")

    // Construa o URI com o número formatado e inclua uma mensagem inicial
    val message = "Oi, estou entrando em contato pelo aplicativo Rent-It."
    val uri = Uri.parse(
        "whatsapp://send?phone=$formattedPhoneNumber&text=${
            URLEncoder.encode(
                message,
                "UTF-8"
            )
        }"
    )

    // Crie o intent e inicie a atividade
    val whatsappIntent = Intent(Intent.ACTION_VIEW, uri)
    ContextCompat.startActivity(context, whatsappIntent, null)
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatePickerButton(
    label: String,
    icon: ImageVector,
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Button(
        shape = MaterialTheme.shapes.small,
        onClick = {
            expanded = true
        },
        contentPadding = PaddingValues(8.dp),
//        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = label,
            fontSize = 16.sp
        )
    }

    if (expanded) {
        DatePickerDialog(
            LocalContext.current,
            { _, year, month, dayOfMonth ->
                val selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
                onDateSelected(selectedDate)
                expanded = false
            },
            selectedDate.year,
            selectedDate.monthValue - 1,
            selectedDate.dayOfMonth
        ).show()
    }
}









