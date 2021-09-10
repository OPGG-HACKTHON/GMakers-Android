package com.example.gmakers_android.feature.sign.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.MainApplication
import com.example.gmakers_android.data.ApiProvider
import com.example.gmakers_android.data.local.SharedPreferenceStorage
import com.example.gmakers_android.data.remote.sign.SignApi
import com.example.gmakers_android.feature.sign.model.LoginRequest
import com.example.gmakers_android.feature.sign.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel() : ViewModel() {

    val loginInterface = ApiProvider.getInstnace().create(SignApi::class.java)

    val userId = MutableLiveData<String>()

    val userPassword = MutableLiveData<String>()

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

    val token:String = ""

    fun doLogin() {
        val sharedPreferenceStorage = SharedPreferenceStorage
        val accessToken = sharedPreferenceStorage.saveInfo(MainApplication.context(), "access_token",token)
        val loginCall =
            loginInterface.doLogin(accessToken,LoginRequest(userId.value!!, userPassword.value!!))
        loginCall.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                if (response.isSuccessful) {
                    _toastMessage.value = "로그인 성공"
                    SharedPreferenceStorage.saveInfo(MainApplication.context(), userId.value!!, "user_email")
                    SharedPreferenceStorage.saveInfo(MainApplication.context(), userPassword.value!!, "user_password")
                }
                    SharedPreferenceStorage.saveInfo(MainApplication.context(), response.body()?.token ?: "","access_token")
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                _toastMessage.value = "로그인"
            }
        })
    }
}