package com.example.gmakers_android.feature.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.MainApplication
import com.example.gmakers_android.data.ApiProvider
import com.example.gmakers_android.data.local.SharedPreferenceStorage
import com.example.gmakers_android.data.model.Profile
import com.example.gmakers_android.data.remote.profile.ProfileApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyProfileListViewModel() : ViewModel() {
    val profileInterface = ApiProvider.getInstnace().create(ProfileApi::class.java)

    private val _profiles = MutableLiveData<List<Profile>>()
    val profiles: LiveData<List<Profile>> = _profiles

    fun getProfiles() {
        val token = SharedPreferenceStorage.getInfo("access_token")
        profileInterface.getProfiles(token).enqueue(object : Callback<List<Profile>> {
            override fun onResponse(
                call: Call<List<Profile>>,
                response: Response<List<Profile>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        _profiles.value = it
                    }
                }
            }

            override fun onFailure(call: Call<List<Profile>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}