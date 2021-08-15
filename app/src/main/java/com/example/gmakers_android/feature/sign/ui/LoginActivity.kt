package com.example.gmakers_android.feature.sign.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import com.example.gmakers_android.R
import com.example.gmakers_android.data.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityLoginBinding
import com.example.gmakers_android.feature.sign.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    override val vm: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
    }

    override fun onStart() {
        super.onStart()
        goRegister()

    }


   fun goRegister(){
       binding.goRegisterTv.setOnClickListener {
           val intent = Intent(this,RegisterActivity::class.java)
           startActivity(intent)
       }
   }
}