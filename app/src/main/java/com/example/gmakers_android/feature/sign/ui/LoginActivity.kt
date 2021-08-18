package com.example.gmakers_android.feature.sign.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityLoginBinding
import com.example.gmakers_android.feature.sign.viewmodel.LoginViewModel
import com.example.gmakers_android.feature.main.ui.MainActivity

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

                // login 성공하면 main activity로 이동
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
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