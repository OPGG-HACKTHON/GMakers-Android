package com.example.gmakers_android.feature.sign.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import com.example.gmakers_android.databinding.ActivityLoginBinding
import com.example.gmakers_android.feature.sign.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    val vm: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding.doRegisterTv.setOnClickListener{

        }

    }


}