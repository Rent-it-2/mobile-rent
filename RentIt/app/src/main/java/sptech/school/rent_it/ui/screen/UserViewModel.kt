package sptech.school.rent_it.ui.screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import sptech.school.rent_it.data.models.CreditCard
import sptech.school.rent_it.data.models.Item
import sptech.school.rent_it.data.models.LoginRequest
import sptech.school.rent_it.data.models.RegistrationRequest
import sptech.school.rent_it.data.models.User
import sptech.school.rent_it.data.network.Service
import sptech.school.rent_it.utils.Routes

class UserViewModel(
    private val service: Service
) : ViewModel() {

    private val _userData: MutableLiveData<User> = MutableLiveData()
    val userData: LiveData<User>
        get() = _userData

    private val _userLoggin: MutableLiveData<LoginRequest> = MutableLiveData()
    val userLoggin: LiveData<LoginRequest>
        get() = _userLoggin

    private val _userRegistration: MutableLiveData<RegistrationRequest> = MutableLiveData()
    val userRegistration: LiveData<RegistrationRequest>
        get() = _userRegistration

    private val _userCartoes: MutableLiveData<List<CreditCard>> = MutableLiveData()
    val userCartoes: LiveData<List<CreditCard>>
        get() = _userCartoes

    private val _userItems: MutableLiveData<List<Item>> = MutableLiveData()
    val userItems: LiveData<List<Item>>
        get() = _userItems

//    fun login(email: String?, senha: RegistrationScreen.ktString?): Boolean {
//
//        for (user in users) {
//            if (email == user.email &&
//                senha == user.senha
//            ) {
//                _userData.value = user
//                return true
//            }
//        }
//        return false
//    }

    fun login(email: String, senha: String, navController: NavHostController) {
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(email, senha)
                val userLogged = service.postLogin(loginRequest)
                _userData.value = userLogged
                Log.d("Service error:", "Response: login: ${_userData.value}")
                navController.navigate(Routes.PRODUCT_SCREEN)
            } catch (e: Exception) {
                Log.d("Service error:", e.toString())
            }
        }
    }

    fun registration(
        nomeCompleto: String,
        apelido: String,
        email: String,
        telefone: String,
        password: String,
        navController: NavHostController
    ) {
        viewModelScope.launch {

            try {
                val request = RegistrationRequest(
                    nome = nomeCompleto,
                    apelido = apelido,
                    email = email,
                    telefone = telefone,
                    password = password
                )
                val userRegistration = service.postRegistration(request)
//                _userData.value = userRegistration
                Log.d("Service success:", "Response: $userRegistration")
                navController.navigate(Routes.LOGIN_SCREEN)
            } catch (e: Exception) {
                Log.d("Service error:", e.toString())
            }
        }
    }


    fun getUserCards() {
        viewModelScope.launch {
            try {
                val userCards =
                    service.getUserCartaos(userData.value?.id, "Bearer${userData.value?.token}")
                _userCartoes.value = userCards
                Log.d("Service error:", "Response: cartões: ${_userCartoes.value}")
            } catch (e: Exception) {
                Log.d("Service error:", e.toString())
            }
        }
    }

    fun getUserItems() {
        viewModelScope.launch {
            try {
                val userItems =
                    service.getUserItems(userData.value?.id, "Bearer${userData.value?.token}")
                _userItems.value = userItems
                Log.d("Service error:", "Response: itens do usuário: ${_userItems.value}")
            } catch (e: Exception) {
                Log.d("Service error:", e.toString())
            }
        }
    }
}