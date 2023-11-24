package sptech.school.rent_it.data.models

data class Adress(
    var numero: Int,
    var cep: String,
    var complemento: String,
    var cidade: String,
    var bairro: String,
    var logradouro: String,
    var usuario: User,
)

//var adresses: MutableList<Adress> = mutableListOf(
//    Adress(
//        numero = 456,
//        cep = "09137709",
//        complemento = "Apartamento 13",
//        cidade = "São Paulo",
//        bairro = "Gaviuera",
//        logradouro = "Bonifacio",
//        usuario = users[0],
//    ),
//)
