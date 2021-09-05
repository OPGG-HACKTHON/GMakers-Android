package com.example.gmakers_android.feature.detail.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityProfileDetailBinding
import com.example.gmakers_android.feature.detail.viewmodel.ProfileDetailViewModel
import com.example.gmakers_android.feature.verify.ui.VerifyActivity
import com.example.gmakers_android.util.ImageMappingUtil
import com.google.android.material.chip.Chip

class ProfileDetailActivity : BaseActivity<ActivityProfileDetailBinding>(R.layout.activity_profile_detail) {

    override val vm: ProfileDetailViewModel = ProfileDetailViewModel()

    companion object {
        const val INTENT_KEY_PROFILE_ID = "intent_key_profile_id"
        const val INTENT_KEY_PROFILE_OWNER = "intent_key_profile_owner"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // observe
        initObserver()

        // listener
        binding.authTv.setOnClickListener {
            vm.profile.value?.let {
                val intent = Intent(this@ProfileDetailActivity, VerifyActivity::class.java)
                intent.putExtra(VerifyActivity.INTENT_KEY_PROFILE, it)
                startActivity(intent)
            }
        }

        val profileOwner = intent.getBooleanExtra(INTENT_KEY_PROFILE_OWNER, true)
        if (!profileOwner) {
            binding.modifyIv.visibility = View.GONE
        }
    }

    override fun onStart() {
        super.onStart()

        val profileId = intent.getIntExtra(INTENT_KEY_PROFILE_ID, -1)
        if (profileId == -1) return

        vm.getDetailProfile(profileId)
    }

    private fun initObserver() {
        vm.profile.observe(this, {
            if (it.certified) {
                binding.root.setBackgroundResource(R.drawable.background_profile_detail_verified)
                binding.authTv.visibility = View.GONE
            } else {
                binding.root.setBackgroundResource(R.drawable.background_profile_detail_unverified)
                binding.authTv.visibility = View.VISIBLE
            }

            // profile card
            binding.profileView.tier = it.tier ?: "NONE"
            binding.profileView.level = it.level.toString()
            binding.profileView.summonerName = it.summonerName
            binding.profileView.tierEmblem = ImageMappingUtil.getEmblemImageResource(it.tier ?: "NONE")
            it.preferLines.forEachIndexed { index, preferLine ->
                when (index) {
                    0 -> binding.profileView.lane01 = ImageMappingUtil.getPositionImageResource(preferLine.line)
                    1 -> binding.profileView.lane02 = ImageMappingUtil.getPositionImageResource(preferLine.line)
                }
            }
            binding.profileView.verified = it.certified

            binding.summonerNameTv.text = it.summonerName
            binding.emblemIv.setImageResource(ImageMappingUtil.getEmblemImageResource(it.tier ?: "NONE"))
            binding.tierTv.text = it.tier ?: "NONE"
            binding.battleInfoTv.text = "${it.leaguePoint}LP ${it.winGames}승 ${it.loseGames}패 (${it.winRate}%)"
            it.preferLines.forEachIndexed { index, preferLine ->
                when (index) {
                    0 -> binding.lane01Iv.setImageResource(ImageMappingUtil.getPositionImageResource(preferLine.line))
                    1 -> binding.lane02Iv.setImageResource(ImageMappingUtil.getPositionImageResource(preferLine.line))
                }
            }
            binding.descTv.text = it.discription
            it.preferKeyword?.forEach {
                val chip = Chip(this)
                chip.text = it.keyword
                binding.keywordCg.addView(chip)
            }
        })
    }
}