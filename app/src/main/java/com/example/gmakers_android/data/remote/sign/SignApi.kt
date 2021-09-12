package com.example.gmakers_android.data.remote.sign

import com.example.gmakers_android.feature.sign.model.LoginRequest
import com.example.gmakers_android.feature.sign.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface SignApi {
    @POST("/api/accounts/sign-in")
    fun doLogin(@Header("Authorization") token: Unit, @Body request: LoginRequest):Call<LoginResponse>

}