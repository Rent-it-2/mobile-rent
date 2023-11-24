package sptech.school.rent_it.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import sptech.school.rent_it.data.models.LoginRequest
import sptech.school.rent_it.ui.components.Input
import sptech.school.rent_it.ui.screen.UserViewModel
import sptech.school.rent_it.ui.theme.typography
import sptech.school.rent_it.utils.Routes

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: UserViewModel,
//    user: User?,
    navController: NavHostController
) {
    val loginRequest by viewModel.userLoggin.observeAsState()
//    var loginRequest by remember { mutableStateOf(LoginRequest("", "")) }
    var email by remember { mutableStateOf(loginRequest?.email?:"") }
    var senha by remember { mutableStateOf(loginRequest?.password ?: "") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val (focusEmail, focusPassword) = remember { FocusRequester.createRefs() }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(64.dp),
            modifier = Modifier
                .fillMaxHeight()
                .padding(24.dp)
        ) {

            Column(modifier = Modifier) {
                Text(
                    text = stringResource(R.string.ol_bem_vindo_de_volta),
                    style = typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = stringResource(R.string.sentimos_sua_falta),
                    style = typography.titleLarge,
                    color = MaterialTheme.colorScheme.outline
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Input(
                    label = stringResource(R.string.email),
                    value = email,
                    onValueChange = { newText ->
                        email = newText
                    },
                    imeAction = ImeAction.Next,
                    keyBoardType = KeyboardType.Email,
                    focusItem = focusEmail,
                    keyboardActions = KeyboardActions(onNext = { focusPassword.requestFocus() }),
                    placeholder = {
                        Text(text = stringResource(R.string.digite_seu_email))
                    },
                )

                Input(
                    label = stringResource(R.string.senha),
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
                    },
                )

                Button(
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    onClick = {
//                        if (viewModel.login(email, senha)) {
//                            navController.navigate(Routes.PRODUCT_SCREEN)
//                        }
                        viewModel.login(email, senha, navController)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.entrar),
                        fontSize = 16.sp
                    )
                }
            }

//            Row(
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = modifier
//                    .fillMaxSize()
//            ) {
//                Text(
//                    text = stringResource(R.string.n_o_possui_uma_conta),
//                    style = MaterialTheme.typography.titleSmall,
//                    color = MaterialTheme.colorScheme.onSurfaceVariant
//                )
//                TextButton(
//                    onClick = {
//                        navController.navigate(Routes.RESGISTRATION_SCREEN)
//                    }) {
//                    Text(
//                        text = stringResource(R.string.cadastrar_se),
//                        fontSize = 16.sp
//                    )
//                }
//            }
        }
    }
}

//@Preview(showBackground = true)
//@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
//@Composable
//fun LoginScreenDarkPreview() {
//    RentItTheme {
//        LoginScreen(viewModel = viewModel(),navController = rememberNavController())
//    }
//}