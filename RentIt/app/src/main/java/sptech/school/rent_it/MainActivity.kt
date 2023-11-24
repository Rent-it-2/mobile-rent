package sptech.school.rent_it

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import sptech.school.rent_it.data.network.service
import sptech.school.rent_it.ui.screen.ProductViewModel
import sptech.school.rent_it.ui.screen.UserViewModel
import sptech.school.rent_it.ui.theme.RentItTheme

class MainActivity : ComponentActivity() {
    private val viewModelUser by viewModels<UserViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return UserViewModel(service) as T
            }
        }
    }
    private val viewModelProduct by viewModels<ProductViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ProductViewModel(service) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            RentItTheme {
                RentItApp(
                    viewModelProduct = viewModelProduct,
                    viewModelUser = viewModelUser,
                    navController = navController,
                )
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RentItTheme {
        Greeting("Android")
    }
}