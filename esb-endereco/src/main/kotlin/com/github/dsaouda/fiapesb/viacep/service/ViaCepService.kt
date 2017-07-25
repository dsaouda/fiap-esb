package com.github.dsaouda.fiapesb.viacep.service

import com.github.dsaouda.fiapesb.viacep.model.Endereco
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


open interface ViaCepService {
    @GET("/ws/{codigo}/json/")
    fun getEndereco(@Path("codigo") codigo: String): Call<Endereco>

    companion object factory {
        fun create(): ViaCepService {

            val retrofit = Retrofit
                    .Builder()
                    .baseUrl("https://viacep.com.br")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(ViaCepService::class.java);
        }
    }
}