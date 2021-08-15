package com.example.gmakers_android.feature.sign.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.data.remote.register.RegisterImpl
import com.example.gmakers_android.feature.sign.model.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel(private val registerImpl: RegisterImpl) : ViewModel() {

    val userName = MutableLiveData<String>()
    val userPassword = MutableLiveData<String>()
    val userRePassword = MutableLiveData<String>()

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

    fun doRegister() {
        val request = RegisterRequest(userName.value!!, userPassword.value!!)
        registerImpl.registerApi(request).subscribe({
            when (it.code()) {
                200 -> {
                    _toastMessage.value = "로그인 성공입니다"
                }
                else -> {
                    _toastMessage.value = "잘못된 로그인 정보입니다"
                }
            }
        }, {
            _toastMessage.value = "로그인에 실패하였습니다"
        })
    }
}