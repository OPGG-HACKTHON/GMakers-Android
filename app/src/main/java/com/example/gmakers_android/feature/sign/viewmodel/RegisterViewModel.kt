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


class RegisterViewModel() : ViewModel() {
    val registerInterface = ApiProvider.getClient().create(RegisterApi::class.java)

    val userName = MutableLiveData<String>()
    val userPassword = MutableLiveData<String>()
    val userRePassword = MutableLiveData<String>()

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

    fun doRegister() {
        val registerCall = registerInterface.doRegister(RegisterRequest(userName.value!!, userPassword.value!!))
        registerCall.enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                when (response.code()) {
                    200 -> {

                    }
                    else -> {

                    }
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d("RegisterActivity", t.toString())
            }
        })
    }
}