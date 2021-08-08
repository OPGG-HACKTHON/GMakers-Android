package com.example.gmakers_android.feature.sign.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.gmakers_android.databinding.ActivityRegisterBinding
import com.example.gmakers_android.feature.sign.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    val vm: RegisterViewModel by viewModels()
    private lateinit var binding: ActivityRegisterBinding

    private fun passwordErrorMessage() {
        if (vm.nEmptyPassword.value!!) {
            binding.signinIdLayout.error = null
        } else {
            binding.signinPwLayout.error = "8~20자리 사이의 비밀번호를 입력해주세요"
        }
    }

}