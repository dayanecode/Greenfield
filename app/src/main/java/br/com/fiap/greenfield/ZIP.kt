package br.com.fiap.greenfield

import com.google.gson.annotations.SerializedName

data class ZIP (
    @SerializedName("cep") val cep: String,
    @SerializedName("rua") val rua: String,
    @SerializedName("complemento") val complemento: String,
    @SerializedName("bairro") val bairro: String,
    @SerializedName("cidade") val cidade: String
)