package com.example.gmakers_android.feature.profile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.feature.profile.model.LineRequest

class EditProfileViewModel() :
    ViewModel() {

    val keywords = MutableLiveData<ArrayList<String>>()
    val preferLines = ArrayList<LineRequest>()
    var userRank = String()


    fun setKeywords(list: ArrayList<String>) {
        keywords.value = list
    }
}
