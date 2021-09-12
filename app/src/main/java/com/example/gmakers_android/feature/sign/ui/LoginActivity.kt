package com.example.gmakers_android.feature.sign.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityLoginBinding
import com.example.gmakers_android.feature.main.ui.MainActivity
import com.example.gmakers_android.feature.sign.viewmodel.LoginViewModel

class LoginActivity: BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.vm = vm
        goRegister()

    }

    override val vm: LoginViewModel = LoginViewModel()

    override fun onStart() {
        super.onStart()
        successLogin()


    }

    fun successLogin(){
        vm.run {
            toastMessage.observe(this@LoginActivity, { message ->
                Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()

                val intent = Intent(this@LoginActivity,  MainActivity::class.java)
                startActivity(intent)

                finish()
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