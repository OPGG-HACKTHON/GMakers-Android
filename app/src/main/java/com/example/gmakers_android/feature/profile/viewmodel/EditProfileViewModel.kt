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

class EditProfileViewModel() :
    ViewModel() {

    val userName = MutableLiveData<String>()
    val userComment = MutableLiveData<String>()
    val keywords = MutableLiveData<ArrayList<String>>()
    val preferLines = ArrayList<LineRequest>()
    var userRank = String()


    fun setKeywords(list: ArrayList<String>) {
        keywords.value = list
    }
}
