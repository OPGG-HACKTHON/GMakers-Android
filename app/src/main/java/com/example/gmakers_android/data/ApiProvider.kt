package com.example.gmakers_android.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {
    private const val BASE_URL: String = "http://52.79.197.237:8080"
    private var retrofit : Retrofit

    init {
        val client = OkHttpClient.Builder()
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun getClient(): Retrofit {
        return retrofit
    }



}