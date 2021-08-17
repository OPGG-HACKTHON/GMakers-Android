package com.example.gmakers_android.feature.sign.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.gmakers_android.R
import com.example.gmakers_android.data.base.BaseActivity
import com.example.gmakers_android.data.local.SharedPreferenceStorage
import com.example.gmakers_android.databinding.ActivityLoginBinding
import com.example.gmakers_android.feature.sign.viewmodel.LoginViewModel
import com.example.gmakers_android.feature.sign.viewmodel.RegisterViewModel

class LoginActivity: BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    override val vm: LoginViewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.vm = vm
        goRegister()

    }

    override fun onStart() {
        super.onStart()
        successLogin()


    }

    fun successLogin(){
        vm.run {
            toastMessage.observe(this@LoginActivity, { message ->
                Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
            })
        }
    }


   fun goRegister(){
       binding.goRegisterTv.setOnClickListener {
           val intent = Intent(this,RegisterActivity::class.java)
           startActivity(intent)
       }
   }
}