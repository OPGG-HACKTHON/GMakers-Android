package com.example.gmakers_android.feature.sign.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gmakers_android.feature.sign.model.LoginRequest

class LoginViewModel():ViewModel() {

    val userId = MutableLiveData<String>()
    val idDone = MutableLiveData(false)

    val userPassword = MutableLiveData<String>()
    val passwordDone = MutableLiveData(false)

    private val goRegister = MutableLiveData(false)

    fun doLogin(login: LoginRequest){
        if(idDone.value!!&&passwordDone.value!!) {


        }
    }
    fun goRegister(){
        userId.value = null
        userPassword.value = null
        goRegister.value = true
    }


}