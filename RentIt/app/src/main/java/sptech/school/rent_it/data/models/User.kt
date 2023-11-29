package sptech.school.rent_it.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerializedName("id") var id: Int?,
    @SerializedName("nome") var nome: String?,
    @SerializedName("apelido") var apelido: String?,
    @SerializedName("email") var email: String?,
    @SerializedName("telefone") var telefone: String?,
    @SerializedName("token") var token: String?,
    @SerializedName("userId") var userId: Int?,
)

@Serializable
data class RegistrationRequest(
    @SerializedName("nome") var nome: String?,
    @SerializedName("apelido") var apelido: String?,
    @SerializedName("email") var email: String?,
    @SerializedName("telefone") var telefone: String?,
    @SerializedName("password") var password: String?
)

data class LoginRequest(
    var email: String,
    var password: String
)

//var users: MutableList<User> = mutableListOf(
//    User(
//        id = "1",
//        nomeCompleto = "Rodrigo Lima",
//        apelido = "Rodrigo",
//        email = "rod@gmail.com",
//        telefone = "(11) 62788-9865",
//        cpf = "11111111111",
//        senha = "123"
//    ),
//    User(
//        id = "2",
//        nomeCompleto = "Ronaldo Da silva",
//        apelido = "Ronaldo",
//        email = "r@gmail.com",
//        telefone = "(11) 747373-9876",
//        cpf = "11111111111",
//        senha = "123"
//    ),
//    User(
//        id = "3",
//        nomeCompleto = "Daniele Da silva",
//        apelido = "Dani",
//        email = "d@gmail.com",
//        telefone = "(11) 96786-0485",
//        cpf = "11111111111",
//        senha = "123"
//    ),
//    User(
//        id = "4",
//        nomeCompleto = "Pablo Da silva",
//        apelido = "Pablo",
//        email = "p@gmail.com",
//        telefone = "(11) 98496-7999",
//        cpf = "11111111111",
//        senha = "123"
//    )
//)