package com.example.gmakers_android.feature.main.ui

import android.content.Intent
import android.os.Bundle
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityMainBinding
import com.example.gmakers_android.feature.main.adapter.ProfileViewPagerAdapter
import com.example.gmakers_android.feature.main.viewmodel.MainViewModel
import com.example.gmakers_android.feature.profile.ui.EditProfileActivity
import com.example.gmakers_android.feature.search.ui.SearchActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override val vm: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.profileVp.adapter = ProfileViewPagerAdapter(this)

        TabLayoutMediator(binding.profileTab, binding.profileVp) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "내 카드"
                }
                1 -> {
                    tab.text = "북마크"
                }
            }
        }.attach()

        binding.addIv.setOnClickListener {

        }

        binding.searchLl.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        binding.addIv.setOnClickListener {
            val intent = Intent(this,EditProfileActivity::class.java)
            startActivity(intent)
        }
    }
}