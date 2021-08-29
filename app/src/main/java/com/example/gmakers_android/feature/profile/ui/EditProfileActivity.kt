package com.example.gmakers_android.feature.profile.ui

import android.os.Bundle
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityEditProfileBinding
import com.example.gmakers_android.feature.profile.viewmodel.EditProfileViewModel

class EditProfileActivity : BaseActivity<ActivityEditProfileBinding>(R.layout.activity_edit_profile) {

    override val vm : EditProfileViewModel = EditProfileViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}