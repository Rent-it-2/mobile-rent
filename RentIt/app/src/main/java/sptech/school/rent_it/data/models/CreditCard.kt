package sptech.school.rent_it.data.models

data class CreditCard(
    val id: Int,
    var numCartao: String,
    var validade: String,
    var cpfTitular: String,
    var usuario: User,
    var nomeImpresso: String
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