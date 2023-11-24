package sptech.school.rent_it.ui.screens.profile

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Label
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Label
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import sptech.school.rent_it.R
import sptech.school.rent_it.ui.components.AdressList
import sptech.school.rent_it.ui.components.Avatar
import sptech.school.rent_it.ui.components.CreditCardList
import sptech.school.rent_it.ui.components.ItemList
import sptech.school.rent_it.ui.screen.UserViewModel
import sptech.school.rent_it.ui.theme.RentItTheme
import sptech.school.rent_it.ui.theme.typography

data class TabItem(
    val title: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

val TAB_ITENS = listOf(
    //    TabItem(
//        title = R.string.meus_dados,
//        route = Routes.PRODUCT_SCREEN,
//        selectedIcon = Icons.Filled.Person2,
//        unselectedIcon = Icons.Outlined.Person2,
//    ),
    TabItem(
        title = R.string.meus_itens,
//        route = Routes.PRODUCT_SCREEN,
        selectedIcon = Icons.Filled.Label,
        unselectedIcon = Icons.Outlined.Label,
    ),
    TabItem(
        title = R.string.cartoes,
//        route = Routes.PRODUCT_SCREEN,
        selectedIcon = Icons.Filled.CreditCard,
        unselectedIcon = Icons.Outlined.CreditCard,
    ),
        TabItem(
        title = R.string.enderecos,
//        route = Routes.PRODUCT_SCREEN,
        selectedIcon = Icons.Filled.Map,
        unselectedIcon = Icons.Outlined.Map,
    ),
)

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: UserViewModel,
) {
    val userInfos by viewModel.userData.observeAsState()
    var selectedTabIndex by rememberSaveable { mutableStateOf(0) }
    val pagerState = rememberPagerState(TAB_ITENS.size)

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp)
        ) {
            Avatar(
                drawableResource = R.drawable.avatar_8,
                description = stringResource(id = R.string.perfil),
                modifier = Modifier.size(80.dp),
                onClick = {}
            )
            Text(
                text = userInfos!!.nome.toString(),
                style = typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = userInfos!!.email.toString(),
                    style = typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Text(
                    text = userInfos!!.telefone.toString(),
                    style = typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }

        TabRow(selectedTabIndex = selectedTabIndex) {
            TAB_ITENS.forEachIndexed { index, item ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                    }) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            imageVector = if (selectedTabIndex == index) item.selectedIcon
                            else item.unselectedIcon,
                            contentDescription = stringResource(id = item.title)
                        )
                        Text(
                            text = stringResource(id = item.title),
                            style = typography.bodySmall,
                            color = MaterialTheme.colorScheme.surfaceTint
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                    }
                }
            }
        }

        HorizontalPager(
            pageCount = TAB_ITENS.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                when (selectedTabIndex) {
                    in 0..0 ->{
                        viewModel.getUserItems()
                        ItemsTab(viewModel)
                    }
                    in 1..1 -> {
                        viewModel.getUserCards()
                        CreditCardTab(viewModel)
                    }
                }
            }

        }
    }
}

@Composable
fun ItemsTab(
    viewModel: UserViewModel,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.padding(8.dp))
    ItemList(viewModel, modifier)
}

@Composable
fun CreditCardTab(
    viewModel: UserViewModel,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.padding(8.dp))
    CreditCardList(viewModel, modifier)
}

//@Composable
//fun AdressTab(
//    viewModel: UserViewModel,
//    modifier: Modifier = Modifier
//) {
//    Spacer(modifier = Modifier.padding(8.dp))
//    AdressList(viewModel, modifier)
//}

//@Preview(showBackground = true)
//@Preview(
//    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES
//)
//@Composable
//fun ProfileScreenDarkPreview() {
//    RentItTheme {
//        ProfileScreen(
//            navController = rememberNavController(),
//            navigateToDetail = {}
//        )
//    }
//}