package sptech.school.rent_it.data.models

import com.google.gson.annotations.SerializedName

data class Transaction(
    @SerializedName("cartaoId") var cartaoId: Int?,
    @SerializedName("cpf") var cpf: String?,
    @SerializedName("dtFim") var dtFim: String?,
    @SerializedName("dtInicio") var dtInicio: String?,
    @SerializedName("itemId") var itemId: Int?,
    @SerializedName("idUso") var idUso: Int?,
    @SerializedName("valorFinal") var valorFinal: Int?
)