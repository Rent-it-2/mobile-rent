package sptech.school.rent_it.ui.screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import sptech.school.rent_it.data.models.CompleteItem
import sptech.school.rent_it.data.models.Item
import sptech.school.rent_it.data.network.Service
import sptech.school.rent_it.utils.Routes

class ProductViewModel(
    private val service: Service
) : ViewModel() {
    private val _itemsData: MutableLiveData<List<Item>> = MutableLiveData()
    val itemsData: LiveData<List<Item>>
        get() = _itemsData

    private val _itemSelected: MutableLiveData<CompleteItem> = MutableLiveData()
    val itemSelected: LiveData<CompleteItem>
        get() = _itemSelected

    private val _itemsSearched: MutableLiveData<List<Item>> = MutableLiveData()
    val itemSearched: LiveData<List<Item>>
        get() = _itemsSearched

    init {
        getItems()
    }

    fun getItems() {
        viewModelScope.launch {
            try {
                val items = service.getItems()
//                for (items in items) {
//                    val poster = service.getPoster(items.imdbID)
//                    items.posterUrl = poster.Poster
//                    Log.d("Service error:", "url: ${items.posterUrl}")
//                }
                _itemsData.value = items
                Log.d("Service error:", "Response: items: ${_itemsData.value}")
            } catch (e: Exception) {
                Log.d("Service error:", e.toString())
            }
        }
    }

    fun getProductById(id: Int, navController: NavHostController) {
        viewModelScope.launch {
            try {

                val product = service.getItemById(id)
                _itemSelected.value = product
                Log.d(
                    "Service error:",
                    "Response: dados do item: ${_itemSelected.value}, id: $id"
                )
                navController.navigate(Routes.PRODUCT_DETAIL_SCREEN)
            } catch (e: Exception) {
                Log.d("Service error:", e.toString())
            }
        }
    }

    fun getProductByNome(nome: String) {
        viewModelScope.launch {
            try {
                val products = service.getItemByNome(nome)
                _itemsSearched.value = products
                Log.d("Service error:", "Response: items pesquisados: ${_itemsSearched.value}")
            } catch (e: Exception) {
                Log.d("Service error:", e.toString())
            }
        }
    }

    fun rentProduct(navController: NavHostController) {
        navController.navigate(Routes.RENT_PRODUCT_SCREEN)
    }
}