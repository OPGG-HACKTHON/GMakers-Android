package com.example.gmakers_android.feature.profile.ui

import android.content.Intent
import android.os.Bundle
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityEditProfileStartBinding
import com.example.gmakers_android.feature.profile.viewmodel.EditProfileViewModel

class EditProfileStartActivity : BaseActivity<ActivityEditProfileStartBinding>(R.layout.activity_edit_profile_start) {

    override val vm : EditProfileViewModel = EditProfileViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        goIntent()
        goBack()
    }

    fun goBack() {
        binding.backImg.setOnClickListener{
            finish()
        }
    }

    fun goIntent(){
       binding.basicInfoLayout.setOnClickListener {
           val intent = Intent(this,EditProfileActivity::class.java)
           startActivity(intent)
       }
    }

}