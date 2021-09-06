package com.example.gmakers_android.feature.main.ui

import android.os.Bundle
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityProfileBinding
import com.example.gmakers_android.feature.main.viewmodel.ProfileViewModel

class ProfileActivity : BaseActivity<ActivityProfileBinding>(R.layout.activity_profile) {

    override val vm: ProfileViewModel = ProfileViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}