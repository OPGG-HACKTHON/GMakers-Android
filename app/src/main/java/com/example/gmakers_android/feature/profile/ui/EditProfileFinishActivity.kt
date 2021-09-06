package com.example.gmakers_android.feature.profile.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.data.local.SharedPreferenceStorage
import com.example.gmakers_android.databinding.ActivityEditProfileFinishBinding
import com.example.gmakers_android.feature.profile.viewmodel.EditProfileViewModel
import com.example.gmakers_android.feature.sign.viewmodel.LoginViewModel

class EditProfileFinishActivity : BaseActivity<ActivityEditProfileFinishBinding>(R.layout.activity_edit_profile_finish) {

    override val vm: EditProfileViewModel = EditProfileViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        certification()
        nextCertification()

    }

    override fun onStart() {
        super.onStart()
    }

    fun certification(){
        binding.certificationBtn.setOnClickListener {
            //TO DO
        }
    }

    fun nextCertification(){
        binding.nextBtn.setOnClickListener{
            //TO DO
        }
    }



}