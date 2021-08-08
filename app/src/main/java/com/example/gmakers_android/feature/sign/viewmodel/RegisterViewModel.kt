package com.example.gmakers_android.feature.sign.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.data.ApiProvider
import com.example.gmakers_android.data.remote.sign.RegisterApi
import com.example.gmakers_android.feature.sign.model.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel():ViewModel() {
    val registerApi = ApiProvider.getClient().create(RegisterApi::class.java)

    val userName = MutableLiveData<String>()
    val nEmptyName = MutableLiveData(false)

    val userPassword = MutableLiveData<String>()
    val nEmptyPassword = MutableLiveData(false)

    val _checkRegister = MutableLiveData<Int>()
    val checkRegister: LiveData<Int> get() = _checkRegister

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

    fun doRegister(){
        if(nEmptyName.value!! && nEmptyPassword.value!!) {
            val request = RegisterRequest(userName.value!!,userPassword.value!!)
            val registerCall = registerApi.doRegister(request)
            registerCall.enqueue(object : Callback<Unit>{
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                when(response.code()){
                    201 ->{
                        _toastMessage.value = "회원가입에 성공하셨습니다"

                    }
                    400 ->{
                        _toastMessage.value = "회원가입에 실패했습니다"

                    }
                    405 ->{
                        _toastMessage.value = "회원가입에 실패했습니다"

                    }
                    4003 ->{
                        _toastMessage.value = "중복된 아이디입니다"

                    }
                    else ->{
                        _toastMessage.value = "다시 시도해주세요"
                    }
                }

            }
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.e("RegisterActivity",t.toString())
            }
        })
        }
    }
}