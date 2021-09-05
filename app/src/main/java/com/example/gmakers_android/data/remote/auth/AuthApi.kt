package com.example.gmakers_android.data.remote.auth

import com.example.gmakers_android.feature.verify.model.AuthConfirmResponse
import com.example.gmakers_android.feature.verify.model.AuthIconRequest
import com.example.gmakers_android.feature.verify.model.AuthIconResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.PATCH

interface AuthApi {
    @PATCH("api/profiles/auth")
    fun getAuthIconId(
        @Header("Authorization") token: String,
        @Body request: AuthIconRequest
    ): Call<AuthIconResponse>

    @PATCH("api/profiles/auth-confirm")
    fun getAuthConfirm(
        @Header("Authorization") token: String,
        @Body request: AuthIconRequest
    ): Call<AuthConfirmResponse>
}