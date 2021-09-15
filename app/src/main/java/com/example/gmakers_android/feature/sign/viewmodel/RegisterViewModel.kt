package com.example.gmakers_android.feature.sign.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.MainApplication
import com.example.gmakers_android.data.ApiProvider
import com.example.gmakers_android.data.local.SharedPreferenceStorage
import com.example.gmakers_android.data.remote.sign.RegisterApi
import com.example.gmakers_android.feature.sign.model.RegisterRequest
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


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

    fun doRegister(successCallback: () -> Unit) {
        if (userPassword.value?.length.toString() >= 8.toString() || userPassword.value?.length.toString() <= 20.toString()) {
            if (userPassword.value == userRePassword.value) {
                val registerCall = registerInterface.doRegister(
                    RegisterRequest(
                        userName.value!!,
                        userPassword.value!!
                    )
                )
                registerCall.enqueue(object : Callback<Unit> {
                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.isSuccessful) {
                            _toastMessage.value = "성공"
                            successCallback()
                        } else {
                            try {
                                response.errorBody()?.let {
                                    val jsonObject = JSONObject(it.string())
                                    Toast.makeText(MainApplication.context(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show()
                                }
                            } catch (e: Exception) {
                                Toast.makeText(MainApplication.context(), e.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        _toastMessage.value = "회원가입에 실패했습니다"
                    }
                })
            } else {
                pwCheck()
            }
        } else {
            _toastMessage.value = "비밀번호 형식에 맞추어 입력해주세요"
        }
    }
}