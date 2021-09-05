package com.example.gmakers_android.feature.search.ui

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivitySearchBinding
import com.example.gmakers_android.feature.detail.ui.ProfileDetailActivity
import com.example.gmakers_android.feature.search.viewmodel.SearchViewModel

class SearchActivity : BaseActivity<ActivitySearchBinding>(R.layout.activity_search) {

    override val vm: SearchViewModel = SearchViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // observe
        initObserver()

        // listener
        binding.backIv.setOnClickListener {
            finish()
        }

        binding.searchIv.setOnClickListener {
            if (binding.searchEt.text.toString().isNotBlank()) {
                vm.getProfile(binding.searchEt.text.toString())
            }
        }

        binding.summonerInfoCl.setOnClickListener {
            vm.profile.value?.let {
                val intent = Intent(this, ProfileDetailActivity::class.java)
                intent.putExtra(ProfileDetailActivity.INTENT_KEY_PROFILE_ID, it.profileId)
                intent.putExtra(ProfileDetailActivity.INTENT_KEY_PROFILE_OWNER, false)
                startActivity(intent)
            }
        }

        binding.searchEt.setOnKeyListener { view, i, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN &&
                    i == KeyEvent.KEYCODE_ENTER) {
                binding.searchIv.performClick()
                true
            } else {
                false
            }
        }
    }

    private fun initObserver() {
        vm.status.observe(this, {
            when (it) {
                SearchViewModel.SearchStatus.INIT -> {
                    binding.summonerInfoCl.visibility = View.GONE
                    binding.notFoundTv.visibility = View.GONE
                }
                SearchViewModel.SearchStatus.FOUND -> {
                    binding.summonerInfoCl.visibility = View.VISIBLE
                    binding.notFoundTv.visibility = View.GONE
                }
                SearchViewModel.SearchStatus.NOT_FOUND -> {
                    binding.summonerInfoCl.visibility = View.GONE
                    binding.notFoundTv.visibility = View.VISIBLE
                }
            }
        })

        vm.profile.observe(this, {
            val imageFileName = "img_profile_icon_${it.profileIconId}"
            binding.profileIconIv.setImageResource(resources.getIdentifier(imageFileName, "drawable", packageName))

            binding.summonerLevelTv.text = "Lv.${it.level}"
            binding.summonerNameTv.text = it.summonerName
            binding.summonerInfoTv.text = "${it.tier?:"NONE"}"
        })
    }
}