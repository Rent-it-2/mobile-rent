package sptech.school.rent_it.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class Item(
    @SerializedName("id") var id: Int?,
    @SerializedName("nome") var nome: String?,
    @SerializedName("categoria") var categoria: Int?,
    @SerializedName("descricao") var descricao: String?,
    @SerializedName("valorDia") var valDia: Double?
)

@Serializable
data class CompleteItem(
    @SerializedName("id") var id: Int?,
    @SerializedName("nomeItem") var nomeItem: String?,
    @SerializedName("categoria") var categoria: Int?,
    @SerializedName("disponivel") var disponivel: Int?,
    @SerializedName("descricao") var descricao: String?,
    @SerializedName("valorDia") var valorDia: Int?,
    @SerializedName("idUsuario") var idUsuario: Int?,
    @SerializedName("nomeUsuario") var nomeUsuario: String?,
    @SerializedName("apelidoUsario") var apelidoUsario: String?,
    @SerializedName("email") var email: String?,
    @SerializedName("telefone") var telefone: String?
)

//val products: List<Item> = listOf(
//    Item(
//        id = "1",
//        nome = "Furadeira de Luxo",
//        categoria = 3,
//        descricao = "Thought we might be able to go over some details about our upcoming vacation. I've been doing a bit of research and have come across a few paces in Northern Brazil that I think we should check out. One, the north has some of the most predictable wind on the planet. I'd love to get out on the ocean and kitesurf for a couple of days if we're going to be anywhere near or around Taiba. I hear it's beautiful there and if you're up for it, I'd love to go. Other than that, I haven't spent too much time looking into places along our road trip route. I'm assuming we can find places to stay and things to do as we drive and find places we think look interesting. But... I know you're more of a planner, so if you have ideas or places in mind, lets jot some ideas down! Maybe we can jump on the phone later today if you have a second.,\n",
//        valDia = 34.0,
//        usuario = users.get(1)
//    ),
//    Item(
//        id = "2",
//        nome = "Panela de Ferro",
//        categoria = 2,
//        descricao = "Thought we might be able to go over some details about our upcoming vacation. I've been doing a bit of research and have come across a few paces in Northern Brazil that I think we should check out. One, the north has some of the most predictable wind on the planet. I'd love to get out on the ocean and kitesurf for a couple of days if we're going to be anywhere near or around Taiba. I hear it's beautiful there and if you're up for it, I'd love to go. Other than that, I haven't spent too much time looking into places along our road trip route. I'm assuming we can find places to stay and things to do as we drive and find places we think look interesting. But... I know you're more of a planner, so if you have ideas or places in mind, lets jot some ideas down! Maybe we can jump on the phone later today if you have a second.,\n",
//        valDia = 16.50,
//        usuario = users.get(1)
//    ),
//    Item(
//        id = "4",
//        nome = "Vestido Vermelho de Festa",
//        categoria = 4,
//        descricao = "Thought we might be able to go over some details about our upcoming vacation. I've been doing a bit of research and have come across a few paces in Northern Brazil that I think we should check out. One, the north has some of the most predictable wind on the planet. I'd love to get out on the ocean and kitesurf for a couple of days if we're going to be anywhere near or around Taiba. I hear it's beautiful there and if you're up for it, I'd love to go. Other than that, I haven't spent too much time looking into places along our road trip route. I'm assuming we can find places to stay and things to do as we drive and find places we think look interesting. But... I know you're more of a planner, so if you have ideas or places in mind, lets jot some ideas down! Maybe we can jump on the phone later today if you have a second.,\n",
//        valDia = 60.0,
//        usuario = users.get(2)
//    ),
//)

var userItems: MutableList<Item> = mutableListOf(
    Item(
        id = 1,
        nome = "Note gamer",
        categoria = 4,
//        usuario = users[0],
//        disponivel = 0,
        descricao = "Hello",
        valDia = 64.0,
    )
)