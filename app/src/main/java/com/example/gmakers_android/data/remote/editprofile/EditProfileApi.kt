package com.example.gmakers_android.data.remote.editprofile

import com.example.gmakers_android.feature.profile.model.EditProfileRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface EditProfileApi {
    @POST("/api/profiles")
    fun editProfile(@Header("Authorization") token: String, @Body request : EditProfileRequest): Call<Unit>
}