package com.example.gmakers_android.feature.profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.MainApplication
import com.example.gmakers_android.data.ApiProvider
import com.example.gmakers_android.data.local.SharedPreferenceStorage
import com.example.gmakers_android.data.model.Profile
import com.example.gmakers_android.data.model.ProfileDetail
import com.example.gmakers_android.data.remote.profile.ProfileApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfileFinishViewModel: ViewModel() {
    val profileInterface = ApiProvider.getInstnace().create(ProfileApi::class.java)

    private val _profile = MutableLiveData<Profile>()
    val profile: LiveData<Profile> = _profile

    private val _profileDetail = MutableLiveData<ProfileDetail>()
    val profileDetail: LiveData<ProfileDetail> = _profileDetail

    fun getProfiles(summonerName: String) {
        val token = SharedPreferenceStorage.getInfo(MainApplication.context(), "access_token")
        profileInterface.getProfiles(token).enqueue(object : Callback<List<Profile>> {
            override fun onResponse(
                call: Call<List<Profile>>,
                response: Response<List<Profile>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        it.find {
                            it.summonerName == summonerName
                        }?.let {
                            _profile.value = it
                            return
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Profile>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun getDetailProfile(profileId: Int) {
        val token = SharedPreferenceStorage.getInfo(MainApplication.context(), "access_token")
        profileInterface.getDetailProfile(token, profileId).enqueue(object : Callback<ProfileDetail> {
            override fun onResponse(call: Call<ProfileDetail>, response: Response<ProfileDetail>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        _profileDetail.value = it
                    }
                }
            }

            override fun onFailure(call: Call<ProfileDetail>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}