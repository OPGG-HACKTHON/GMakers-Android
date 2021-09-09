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
import com.example.gmakers_android.feature.sign.model.RegisterRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class EditProfileViewModel() :
    ViewModel() {

    val profileInterface = ApiProvider.getInstnace().create(EditProfileApi::class.java)

    val userName = MutableLiveData<String>()
    val userComment = MutableLiveData<String>()
    val keyword = MutableLiveData<String>()
    val priority = MutableLiveData<Int>()
    val championId = MutableLiveData<Int>()
    val line = MutableLiveData<String>()
    val preferChampions = MutableLiveData<ArrayList<ChampionRequest>>()
    val preferLines = MutableLiveData<ArrayList<LineRequest>>()

    val nullable = MutableLiveData<Boolean>(false)

    val userRank = MutableLiveData<String>()

    private val _Check = MutableLiveData<Boolean>()
    val Check: LiveData<Boolean> get() = _Check

    private val _comment = MutableLiveData<String>()
    val comment: LiveData<String> get() = _comment


    fun editProfileAll() {
        val sharedPreferenceStorage = SharedPreferenceStorage
        val accessToeken = sharedPreferenceStorage.getInfo(MainApplication.context(), "access_toekn")
        val request = EditProfileRequest(
            userName.value!!,
            userComment.value!!,
            keyword.value!!,
            preferChampions.value!!,
            preferLines.value!!,
            userRank.value!!
        )
        if (request == null) {
            profileInterface.editProfile(accessToeken, request).enqueue(object : Callback<Unit> {
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    _comment.value = "프로필 생성 성공"
                }

                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    _comment.value = "프로필을 다시 입력해주세요"
                }
            })
        }
        _comment.value = "빠진 곳이 없는지 확인 후에 다시 시도해주세요!"
    }
}
