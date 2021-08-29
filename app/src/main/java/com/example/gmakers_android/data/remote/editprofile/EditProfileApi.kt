package com.example.gmakers_android.data.remote.editprofile

import com.example.gmakers_android.feature.profile.model.EditProfileRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface EditProfileApi {
    @POST("/profiles")
    fun editProfile(@Body request : EditProfileRequest): Call<Unit>
}