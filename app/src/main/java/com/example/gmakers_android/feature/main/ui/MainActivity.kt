package com.example.gmakers_android.feature.main.ui

import android.content.Intent
import android.os.Bundle
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityMainBinding
import com.example.gmakers_android.feature.main.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override val vm: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.addIv.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}