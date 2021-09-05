package com.example.gmakers_android.data.remote.profile

import com.example.gmakers_android.data.model.Profile
import com.example.gmakers_android.data.model.ProfileDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ProfileApi {
    @GET("api/profiles")
    fun getProfiles(
        @Header("Authorization") token: String
    ): Call<List<Profile>>

    @GET("api/profiles/{profileId}")
    fun getDetailProfile(
        @Header("Authorization") token: String,
        @Path("profileId") profileId: Int
    ): Call<ProfileDetail>
}