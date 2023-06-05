package br.com.fiap.greenfield

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("{zip}/json/")
    fun getZIP(@Path("zip") zip: String): Call<ZIP>

}