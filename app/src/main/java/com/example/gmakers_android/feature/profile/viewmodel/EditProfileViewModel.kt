package com.example.gmakers_android.feature.profile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.data.ApiProvider
import com.example.gmakers_android.data.remote.editprofile.EditProfileApi
import com.example.gmakers_android.feature.profile.model.ChampionRequest
import com.example.gmakers_android.feature.profile.model.EditProfileRequest
import com.example.gmakers_android.feature.profile.model.LineRequest
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class EditProfileViewModel() : ViewModel() {

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


    fun editProfileAll() {
        val requestCall = profileInterface.editProfile(
            EditProfileRequest(
                userName.value!!,
                userComment.value!!,
                keyword.value!!,
                preferChampions.value!!,
                preferLines.value!!,
                userRank.value!!
            )
        )


        fun championClick() {
            preferChampions.value?.add(
                ChampionRequest(
                    priority.value!!,
                    championId.value!!,
                    TODO()
                )
            )
        }

        fun LineClick() {
            preferLines.value?.add(LineRequest(priority.value!!, line.value!!, TODO()))
        }

        fun putRank() {


        }
    }
}