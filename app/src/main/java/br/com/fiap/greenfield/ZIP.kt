package br.com.fiap.greenfield

import com.google.gson.annotations.SerializedName

data class ZIP (
    @SerializedName("cep") val zip: String,
    @SerializedName("logradouro") val street: String,
    @SerializedName("bairro") val district: String,
    @SerializedName("localidade") val city: String
)