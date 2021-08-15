package com.example.gmakers_android.feature.sign.viewmodel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.data.ApiProvider
import com.example.gmakers_android.data.remote.sign.SignApi
import com.example.gmakers_android.feature.sign.model.LoginRequest
import com.example.gmakers_android.feature.sign.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel():ViewModel() {
    val loginInterface = ApiProvider.getClient().create(SignApi::class.java)

    val userId = MutableLiveData<String>()
    val idDone = MutableLiveData(false)

    val userPassword = MutableLiveData<String>()
    val passwordDone = MutableLiveData(false)

    private val goRegister = MutableLiveData(false)

    fun doLogin() {
        if (idDone.value!! && passwordDone.value!!) {
            val loginCall = loginInterface.doLogin(LoginRequest(userId.value!!,userPassword.value!!))
            loginCall.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    when (response.code()) {
                        200 -> {

                        }
                        else -> {

                        }
                    }
                }
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.d("LoginActivity", t.toString())
                }
            })
        }
    }
    fun goRegister(){
        userId.value = null
        userPassword.value = null
        goRegister.value = true
    }


}