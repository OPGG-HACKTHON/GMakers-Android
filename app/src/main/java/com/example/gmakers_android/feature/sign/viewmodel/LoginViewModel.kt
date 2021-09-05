package com.example.gmakers_android.feature.sign.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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


    fun doLogin() {
            val loginCall =
                loginInterface.doLogin(LoginRequest(userId.value!!, userPassword.value!!))
            loginCall.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        _toastMessage.value = "로그인 성공"
                        SharedPreferenceStorage.saveInfo(userId.value!!,"user_email")
                        SharedPreferenceStorage.saveInfo(userPassword.value!!,"user_password")
                    }
                    SharedPreferenceStorage.saveInfo(response.body()!!.token,"access_token")
                }
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    _toastMessage.value = "로그인 실패"
                }
            })
    }
}