package com.example.gmakers_android.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiProvider {
    private const val BASE_URL: String = "https://52.79.197.237:8080"
    private const val CONNECT_TIME_OUT: Long = 15
    private const val WRITE_TIME_OUT: Long = 15
    private const val READ_TIME_OUT: Long = 15
    private var retrofit : Retrofit

//    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
//        level = HttpLoggingInterceptor.Level.BODY
//    }
//
//    private val okHttpClient: OkHttpClient = OkHttpClient().newBuilder().apply {
//        addInterceptor(httpLoggingInterceptor)
//        connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
//        writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
//        readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
//    }.build()
//
//    val RetroFitBuilder: Retrofit = Retrofit.Builder().apply {
//        baseUrl(BASE_URL)
//        client(okHttpClient)
//        addConverterFactory(GsonConverterFactory.create())
//    }.build()

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
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