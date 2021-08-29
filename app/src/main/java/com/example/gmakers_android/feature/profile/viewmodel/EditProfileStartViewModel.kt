package com.example.gmakers_android.feature.profile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.data.ApiProvider
import com.example.gmakers_android.data.remote.editprofile.EditProfileApi
import com.example.gmakers_android.data.remote.sign.SignApi

class EditProfileStartViewModel():ViewModel() {

    val EditProfileInterface = ApiProvider.getInstnace().create(EditProfileApi::class.java)

    val simpleIntro = MutableLiveData<String>()
    val keyword = MutableLiveData<String>()
    val position = MutableLiveData<Int>()
    val showRank = MutableLiveData<String>()

//    fun makeProfile(){
//        val EditProfile = EditProfileInterface.editProfile(simpleIntro.value!!)
//
//    }
}