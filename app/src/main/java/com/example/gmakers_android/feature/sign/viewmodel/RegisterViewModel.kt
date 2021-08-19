package com.example.gmakers_android.feature.sign.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.data.ApiProvider
import com.example.gmakers_android.data.local.SharedPreferenceStorage
import com.example.gmakers_android.data.remote.sign.RegisterApi
import com.example.gmakers_android.feature.sign.model.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterViewModel() : ViewModel() {
    val registerInterface = ApiProvider.getInstnace().create(RegisterApi::class.java)

    val userName = MutableLiveData<String>()
    val userPassword = MutableLiveData<String>()
    val userRePassword = MutableLiveData<String>()

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

    private val _pwCheck = MutableLiveData<String>()
    val pwCheck: LiveData<String> get() = _pwCheck


    fun pwCheck() {
        if (userPassword != userRePassword) {
            _pwCheck.value = "비밀번호를 다시 입력해주세요"
        }
    }


    fun doRegister() {
        if (userPassword.value == userRePassword.value) {
            val registerCall = registerInterface.doRegister(
                RegisterRequest(
                    userName.value!!,
                    userPassword.value!!
                )
            )
            registerCall.enqueue(object : Callback<Unit> {
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    when (response.code()) {
                        201 -> {
                            _toastMessage.value = "성공"
                        }
                    }
                }

                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    t.message?.let { Log.d(TAG, it) }
                }
            })
        } else {
            pwCheck()
        }
    }
}