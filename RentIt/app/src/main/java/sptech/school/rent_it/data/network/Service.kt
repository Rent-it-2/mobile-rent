package sptech.school.rent_it.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import sptech.school.rent_it.data.models.CompleteItem
import sptech.school.rent_it.data.models.CreditCard
import sptech.school.rent_it.data.models.Item
import sptech.school.rent_it.data.models.LoginRequest
import sptech.school.rent_it.data.models.RegistrationRequest
import sptech.school.rent_it.data.models.User

interface Service {
    @POST("/usuarios/login")
    suspend fun postLogin(
        @Body loginRequest: LoginRequest
    ): User

    @POST("/usuarios/cadastrar")
    suspend fun postRegistration(
        @Body registrationRequest: RegistrationRequest
    )

    @Headers("Content-Type: application/json")
    @GET("/cartaos/usuario/{id}?id={userId}")
    suspend fun getUserCartaos(
        @Path("userId") id: Int?,
        @Header("Authorization") authorization: String
    ): List<CreditCard>

    @Headers("Content-Type: application/json")
    @GET("/cartaos/{id}?id={cartaoId}")
    suspend fun getCartaoById(
        @Path("cartaoId") id: Int,
        @Header("Authorization") authorization: String
    ): List<CreditCard>

    @Headers("Content-Type: application/json")
    @GET("/itens/usuario?id={userId}")
    suspend fun getUserItems(
        @Path("userId") id: Int?,
        @Header("Authorization") authorization: String
    ): List<Item>

    @GET("/itens")
    suspend fun getItems(): List<Item>

    @GET("/itens/{id}")
    suspend fun getItemById(
        @Path("id") id: Int
    ): CompleteItem

    @GET("/itens/nome/{nome}")
    suspend fun getItemByNome(
        @Path("nome") nome: String
    ): List<Item>
}

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("http://52.0.133.214:8080/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val service: Service = retrofit.create(Service::class.java)