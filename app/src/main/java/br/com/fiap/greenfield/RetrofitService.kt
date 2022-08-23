package br.com.fiap.greenfield

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Part

interface RetrofitService {

    @GET("{ZIP}/json/")
    fun getCEP(@Part("ZIP") CEP : String) : Call<ZIP>

}