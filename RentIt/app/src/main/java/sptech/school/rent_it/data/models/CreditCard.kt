package sptech.school.rent_it.data.models

import com.google.gson.annotations.SerializedName

data class CreditCard(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("cpf") var cpf: String? = null,
    @SerializedName("numCartao") var numCartao: String? = null,
    @SerializedName("validade") var validade: String? = null,
    @SerializedName("nomeUsuario") var nomeUsuario: String? = null
)

//var cards: MutableList<CreditCard> = mutableListOf(
//    CreditCard(
//        id = 1,
//        numCartao = "123456789087",
//        validade = "09/12",
//        cpfTitular = "19192939291",
//        usuario = users[0],
//        nomeImpresso = "Hello"
//    ),
//    CreditCard(
//        id = 2,
//        numCartao = "123456789087",
//        validade = "09/05",
//        cpfTitular = "19192939291",
//        usuario = users[0],
//        nomeImpresso = "Jonathan"
//    ),
//)