package com.example.gmakers_android.data.remote.sign

import com.example.gmakers_android.feature.sign.model.LoginRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface SignApi {
    @POST("/api/accounts/sign-in")
    fun login(@Body request : LoginRequest):Call<LoginRequest>

}