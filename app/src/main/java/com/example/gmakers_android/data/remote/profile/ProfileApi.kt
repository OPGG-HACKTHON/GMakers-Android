package com.example.gmakers_android.data.remote.profile

import com.example.gmakers_android.data.model.Profile
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfileApi {
    @GET("api/profiles")
    fun getProfiles(
        @Header("Authorization") token: String
    ): Call<List<Profile>>
}