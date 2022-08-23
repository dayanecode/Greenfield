package br.com.fiap.greenfield

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitFactory {

    val URL: String = "https://viacep.com.br/ws/"

    val retrifitFactory = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()

    fun retrofitService() : RetrofitService {
        return retrifitFactory.create(RetrofitService::class.java)
    }


}

