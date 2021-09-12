package com.example.gmakers_android.feature.profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.MainApplication
import com.example.gmakers_android.data.ApiProvider
import com.example.gmakers_android.data.local.SharedPreferenceStorage
import com.example.gmakers_android.data.remote.editprofile.EditProfileApi
import com.example.gmakers_android.feature.profile.model.ChampionRequest
import com.example.gmakers_android.feature.profile.model.EditProfileRequest
import com.example.gmakers_android.feature.profile.model.LineRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PickChampionViewModel() :
    ViewModel() {

    val profileInterface = ApiProvider.getInstnace().create(EditProfileApi::class.java)

    val userName = MutableLiveData<String>()
    val userComment = MutableLiveData<String>()
    val keywords = MutableLiveData<List<String>>()
    val priority = MutableLiveData<Int>()
    val championId = MutableLiveData<Int>()
    val line = MutableLiveData<String>()
    val preferChampions = MutableLiveData<ArrayList<ChampionRequest>>()
    var preferLines = ArrayList<LineRequest>()

    val nullable = MutableLiveData<Boolean>(false)

    var userRank = String()

    private val _Check = MutableLiveData<Boolean>()
    val Check: LiveData<Boolean> get() = _Check

    private val _comment = MutableLiveData<String>()
    val comment: LiveData<String> get() = _comment


    fun editProfileAll() {
        val sharedPreferenceStorage = SharedPreferenceStorage
        val accessToeken = sharedPreferenceStorage.getInfo(MainApplication.context(), "access_token")
        val request = EditProfileRequest(
            userName.value!!,
            userComment.value!!,
            keywords.value!!,
            preferChampions.value!!,
            preferLines,
            userRank
        )
        profileInterface.editProfile(accessToeken, request).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    _comment.value = "프로필 생성 성공"
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                _comment.value = "프로필을 다시 입력해주세요"
            }
        })
        _comment.value = "빠진 곳이 없는지 확인 후에 다시 시도해주세요!"
    }

    fun setKeywords(list: List<String>) {
        keywords.value = list
    }
}
