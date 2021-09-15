package com.example.gmakers_android.feature.verify.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.MainApplication
import com.example.gmakers_android.data.ApiProvider
import com.example.gmakers_android.data.local.SharedPreferenceStorage
import com.example.gmakers_android.data.remote.auth.AuthApi
import com.example.gmakers_android.feature.verify.model.AuthConfirmResponse
import com.example.gmakers_android.feature.verify.model.AuthIconRequest
import com.example.gmakers_android.feature.verify.model.AuthIconResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VerifyViewModel : ViewModel() {
    val authInterface = ApiProvider.getInstnace().create(AuthApi::class.java)

    enum class VerifyStatus {
        INIT, CONFIRMING, FAIL, SUCCESS
    }

    private val _status = MutableLiveData<VerifyStatus>()
    val status = _status

    private val _profileIconId = MutableLiveData<String>()
    val profileIconId: LiveData<String> = _profileIconId

    init {
        _status.value = VerifyStatus.INIT
    }

    fun getAuthProfileIconId(summonerId: String, failCallback: () -> Unit) {
        val token = SharedPreferenceStorage.getInfo(MainApplication.context(), "access_token")
        authInterface.getAuthIconId(token, AuthIconRequest(summonerId)).enqueue(object :Callback<AuthIconResponse> {
            override fun onResponse(
                call: Call<AuthIconResponse>,
                response: Response<AuthIconResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        _profileIconId.value = it.iconId
                    }
                } else {
                    Toast.makeText(MainApplication.context(), response.message(), Toast.LENGTH_SHORT).show()
                    failCallback()
                }
            }

            override fun onFailure(call: Call<AuthIconResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun getAuthConfirmed(summonerId: String) {
        _status.value = VerifyStatus.CONFIRMING
        val token = SharedPreferenceStorage.getInfo(MainApplication.context(), "access_token")
        authInterface.getAuthConfirm(token, AuthIconRequest(summonerId)).enqueue(object : Callback<AuthConfirmResponse> {
            override fun onResponse(
                call: Call<AuthConfirmResponse>,
                response: Response<AuthConfirmResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.certified) {
                            _status.value = VerifyStatus.SUCCESS
                            return
                        }
                    }
                }
                _status.value = VerifyStatus.FAIL
            }

            override fun onFailure(call: Call<AuthConfirmResponse>, t: Throwable) {
                _status.value = VerifyStatus.FAIL
                t.printStackTrace()
            }
        })
    }
}