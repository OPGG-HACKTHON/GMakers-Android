package com.example.gmakers_android.feature.profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.MainApplication
import com.example.gmakers_android.data.ApiProvider
import com.example.gmakers_android.data.local.SharedPreferenceStorage
import com.example.gmakers_android.data.model.ProfileDetail
import com.example.gmakers_android.data.remote.profile.ProfileApi
import com.example.gmakers_android.feature.profile.model.LineRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfileViewModel() : ViewModel() {
    val profileInterface = ApiProvider.getInstnace().create(ProfileApi::class.java)

    private val _profile = MutableLiveData<ProfileDetail>()
    val profile: LiveData<ProfileDetail> = _profile

    fun getDetailProfile(profileId: Int) {
        val token = SharedPreferenceStorage.getInfo(MainApplication.context(), "access_token")
        profileInterface.getDetailProfile(token, profileId)
            .enqueue(object : Callback<ProfileDetail> {
                override fun onResponse(
                    call: Call<ProfileDetail>,
                    response: Response<ProfileDetail>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            _profile.value = it
                        }
                    }
                }

                override fun onFailure(call: Call<ProfileDetail>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }
}
