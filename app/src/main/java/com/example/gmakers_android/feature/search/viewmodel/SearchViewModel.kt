package com.example.gmakers_android.feature.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.data.ApiProvider
import com.example.gmakers_android.data.local.SharedPreferenceStorage
import com.example.gmakers_android.data.model.Profile
import com.example.gmakers_android.data.remote.profile.ProfileApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {
    val profileInterface = ApiProvider.getInstnace().create(ProfileApi::class.java)

    enum class SearchStatus {
        INIT, FOUND, NOT_FOUND
    }

    private val _status = MutableLiveData<SearchStatus>()
    val status = _status

    private val _profile = MutableLiveData<Profile>()
    val profile: LiveData<Profile> = _profile

    init {
        _status.value = SearchStatus.INIT
    }

    fun getProfile(summonerName: String) {
        _status.value = SearchStatus.INIT
        val token = SharedPreferenceStorage.getInfo("access_token")
        profileInterface.getProfiles(token, summonerName).enqueue(object : Callback<List<Profile>> {
            override fun onResponse(
                call: Call<List<Profile>>,
                response: Response<List<Profile>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        _profile.value = it[0]
                        _status.value = SearchStatus.FOUND
                        return
                    }
                }
                _status.value = SearchStatus.NOT_FOUND
            }

            override fun onFailure(call: Call<List<Profile>>, t: Throwable) {
                _status.value = SearchStatus.NOT_FOUND
                t.printStackTrace()
            }
        })
    }
}