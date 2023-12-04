package sptech.school.rent_it.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import sptech.school.rent_it.data.models.CompleteItem
import sptech.school.rent_it.data.models.CreditCard
import sptech.school.rent_it.data.models.Item
import sptech.school.rent_it.data.models.LoginRequest
import sptech.school.rent_it.data.models.RegistrationRequest
import sptech.school.rent_it.data.models.Transaction
import sptech.school.rent_it.data.models.User
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

interface Service {
    @POST("/usuarios/login")
    suspend fun postLogin(
        @Body loginRequest: LoginRequest
    ): User

    @POST("/usuarios/cadastrar")
    suspend fun postRegistration(
        @Body registrationRequest: RegistrationRequest
    )

    @POST("/transacoes/alugar-item")
    fun postAlugarItem(@Body body: Transaction)

//    @Headers("Content-Type: application/json")
//    @GET("/cartaos/usuario/{path}")
//    suspend fun getUserCartaos(
//        @Query("path") path: String?,
////        @Query("userId") userId: Int?,
////        @Header("Authorization") authorization: String
//    ): List<CreditCard>
@GET("/cartaos/usuario/{id}")
suspend fun getUserCartaos(
    @Path("id") id: String?,  // Ou o tipo correto, se for diferente de String
    @Query("id") queryId: Int?
): List<CreditCard>

    @Headers("Content-Type: application/json")
    @GET("/cartaos/{id}?id={cartaoId}")
    suspend fun getCartaoById(
        @Query("cartaoId") id: Int,
        @Header("Authorization") authorization: String
    ): List<CreditCard>

    @GET("/itens/usuario")
    suspend fun getUserItems(
        @Query("id") userId: Int?
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

fun createUnsafeOkHttpClient(): OkHttpClient {
    val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
        override fun getAcceptedIssuers(): Array<X509Certificate> = emptyArray()
    })

    val sslContext = SSLContext.getInstance("SSL")
    sslContext.init(null, trustAllCerts, SecureRandom())

    val sslSocketFactory = sslContext.socketFactory

    return OkHttpClient.Builder()
        .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
        .hostnameVerifier { _, _ -> true }
        .build()
}

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://52.0.133.214:8080/")
    .client(createUnsafeOkHttpClient())
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val service: Service = retrofit.create(Service::class.java)