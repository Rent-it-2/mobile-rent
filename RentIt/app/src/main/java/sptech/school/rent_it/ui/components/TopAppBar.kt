package sptech.school.rent_it.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import sptech.school.rent_it.R
import sptech.school.rent_it.ui.screens.NavigationViewModel

import sptech.school.rent_it.ui.theme.RentItTheme
import sptech.school.rent_it.ui.theme.typography
import sptech.school.rent_it.utils.Routes
import sptech.school.rent_it.utils.categories

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    showClasses: Boolean = false,
    viewModel: NavigationViewModel = viewModel(),
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    Column {
        Column {
            TopAppBar(
                title = {
//                    Text(
//                        title,
//                        style = typography.headlineSmall,
//                        color = MaterialTheme.colorScheme.onBackground
//                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onTertiaryContainer
                ),
                modifier = modifier,
                navigationIcon = {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (canNavigateBack) {
                            IconButton(onClick = navigateUp) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = stringResource(R.string.voltar)
                                )
                            }
                        }
                        if (!canNavigateBack) {

                            Image(
                                modifier = modifier
                                    .size(120.dp)
                                    .clickable(onClick = {
                                        viewModel.navigateToPage(
                                            page = Routes.PRODUCT_SCREEN,
                                            navController = navController
                                        )
                                    }),
                                painter = painterResource(id = R.drawable.rent_it_laranja),
                                contentDescription = stringResource(R.string.logo)
                            )
                        }
                    }
                },
                actions = {
                    if (!canNavigateBack) {
                        Spacer(modifier = Modifier.padding(8.dp))

                        Avatar(
                            drawableResource = R.drawable.avatar_8,
                            description = "",
                            onClick = {
                                viewModel.navigateToPage(
                                    page = Routes.PROFILE_SCREEN,
                                    navController = navController
                                )
                            }
                        )

                        Spacer(modifier = Modifier.padding(8.dp))
                    }
                }
            )
        }

        if (showClasses) {

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = modifier
            ) {
                items(categories) { category ->

                    AssistChip(
                        label = {
                            Text(
                                category.name,
                                style = typography.bodySmall
                            )
                        },
                        shape = MaterialTheme.shapes.extraLarge,
                        onClick = {
                            viewModel.navigateToPage(
                                page = Routes.SEARCH_SCREEN,
                                navController = navController
                            )
                        },
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            disabledContainerColor = MaterialTheme.colorScheme.surface,
                            labelColor = MaterialTheme.colorScheme.surfaceTint
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppbarLightPreview() {
    RentItTheme {
        TopAppBar(
            title = "Produtos",
            canNavigateBack = false,
            showClasses = true,
            navigateUp = { /*TODO*/ },
            navController = rememberNavController()
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TopAppbarDarkPreview() {
    RentItTheme {
        TopAppBar(
            title = "Pesquisa",
            canNavigateBack = true,
            navigateUp = { /*TODO*/ },
            navController = rememberNavController()
        )
    }
}