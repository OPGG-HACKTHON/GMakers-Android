package com.example.gmakers_android.feature.sign.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityRegisterBinding
import com.example.gmakers_android.feature.sign.viewmodel.RegisterViewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(R.layout.activity_register) {

    override val vm: RegisterViewModel = RegisterViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.vm = vm
        backClick()

    }

    override fun onStart() {
        super.onStart()
        successRegister()


    }

    fun backClick(){
        binding.backImg.setOnClickListener {
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun successRegister(){
        vm.run {
            toastMessage.observe(this@RegisterActivity, { message ->
                Toast.makeText(this@RegisterActivity, message, Toast.LENGTH_SHORT).show()
            })
        }
    }

}