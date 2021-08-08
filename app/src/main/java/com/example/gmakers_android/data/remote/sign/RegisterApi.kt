package com.example.gmakers_android.data.remote.sign

import com.example.gmakers_android.feature.sign.model.RegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApi {

    @POST("/api/accounts/sign-up")
    fun doRegister(@Body request : RegisterRequest): Call<Unit>
}