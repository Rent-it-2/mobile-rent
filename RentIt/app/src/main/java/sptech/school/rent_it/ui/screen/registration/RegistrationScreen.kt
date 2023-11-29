package sptech.school.rent_it.ui.screen.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import sptech.school.rent_it.R
import sptech.school.rent_it.ui.components.Input
import sptech.school.rent_it.ui.screen.UserViewModel
import sptech.school.rent_it.ui.theme.typography
import sptech.school.rent_it.utils.Routes

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier,
    viewModel: UserViewModel,
    navController: NavHostController,
//    onNavigateLogin: () -> Unit
) {

    val registrationRequest by viewModel.userRegistration.observeAsState()

    var nomeCompleto by remember { mutableStateOf(registrationRequest?.nome ?: "") }
    var apelido by remember { mutableStateOf(registrationRequest?.apelido ?: "") }
    var email by remember { mutableStateOf(registrationRequest?.email ?: "") }
    var telefone by remember { mutableStateOf(registrationRequest?.telefone ?: "") }
//    var cpf by remember { mutableStateOf(registrationRequest?.cpf ?: "") }
    var senha by remember { mutableStateOf(registrationRequest?.password ?: "") }

    var isPasswordVisible by remember { mutableStateOf(false) }
    val (focusNomeCompleto, focusApelido, focusEmail, focusTelefone, focusCpf, focusPassword) = remember { FocusRequester.createRefs() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(24.dp)
        ) {

            Column(modifier = Modifier) {
                Text(
                    text = stringResource(R.string.crie_uma_conta),
                    style = typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = stringResource(R.string.encontre_o_que_precisa_hoje_mesmo),
                    style = typography.titleLarge,
                    color = MaterialTheme.colorScheme.outline
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Input(
                    label = stringResource(R.string.nomecompleto),
                    value = nomeCompleto,
                    onValueChange = { newText ->
                        nomeCompleto = newText
                    },
                    imeAction = ImeAction.Next,
                    keyBoardType = KeyboardType.Text,
                    focusItem = focusNomeCompleto,
                    keyboardActions = KeyboardActions(onNext = { focusApelido.requestFocus() }),
                    placeholder = {
                        Text(text = stringResource(R.string.digite_seu_nome_completo))
                    }
                )

                Input(
                    label = stringResource(R.string.apelido),
                    value = apelido,
                    onValueChange = { newText ->
                        apelido = newText
                    },
                    imeAction = ImeAction.Next,
                    keyBoardType = KeyboardType.Text,
                    focusItem = focusApelido,
                    keyboardActions = KeyboardActions(onNext = { focusEmail.requestFocus() }),
                    placeholder = {
                        Text(text = stringResource(R.string.digite_seu_apelido))
                    }
                )

                Input(
                    label = stringResource(R.string.email),
                    value = email,
                    onValueChange = { newText ->
                        email = newText
                    },
                    imeAction = ImeAction.Next,
                    keyBoardType = KeyboardType.Email,
                    focusItem = focusEmail,
                    placeholder = {
                        Text(text = stringResource(R.string.digite_seu_email))
                    }
                )

                Input(
                    label = stringResource(R.string.telefone),
                    value = telefone,
                    onValueChange = { newText ->
                        telefone = newText
                    },
                    imeAction = ImeAction.Next,
                    keyBoardType = KeyboardType.Phone,
                    focusItem = focusTelefone,
                    keyboardActions = KeyboardActions(onNext = { focusPassword.requestFocus() }),
                    placeholder = {
                        Text(text = stringResource(R.string.digite_seu_telefone))
                    }
                )

//                Input(
//                    label = stringResource(R.string.cpf),
//                    value = cpf,
//                    onValueChange = { newText ->
//                        cpf = newText
//                    },
//                    imeAction = ImeAction.Next,
//                    keyBoardType = KeyboardType.NumberPassword,
//                    focusItem = focusCpf,
//                    keyboardActions = KeyboardActions(onNext = { focusPassword.requestFocus() }),
//                    placeholder = {
//                        Text(text = stringResource(R.string.digite_seu_cpf))
//                    }
//                )

                Input(
                    label = stringResource(id = R.string.senha),
                    value = senha,
                    onValueChange = { newText ->
                        senha = newText
                    },
                    imeAction = ImeAction.Done,
                    keyBoardType = KeyboardType.Password,
                    focusItem = focusPassword,
                    placeholder = {
                        Text(text = stringResource(R.string.digite_sua_senha))
                    },
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                            Icon(
                                imageVector = if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                contentDescription = stringResource(R.string.password_toggle)
                            )
                        }
                    }
                )

                Button(
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    onClick = {
                        viewModel.registration(
                            nomeCompleto = nomeCompleto,
                            apelido = apelido,
                            email = email,
                            telefone = telefone,
                            password= senha,
                            navController
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.cadastrar_se),
                        fontSize = 16.sp
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = stringResource(R.string.j_possui_uma_conta),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                TextButton(onClick = {
                    navController.navigate(Routes.LOGIN_SCREEN)
                }) {
                    Text(
                        text = stringResource(R.string.entre),
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}