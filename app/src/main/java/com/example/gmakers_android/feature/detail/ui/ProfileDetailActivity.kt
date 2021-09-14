package com.example.gmakers_android.feature.detail.ui

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityProfileDetailBinding
import com.example.gmakers_android.feature.detail.viewmodel.ProfileDetailViewModel
import com.example.gmakers_android.feature.profile.ChampionList
import com.example.gmakers_android.feature.verify.ui.VerifyActivity
import com.example.gmakers_android.util.ImageMappingUtil

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

        /*val profileOwner = intent.getBooleanExtra(INTENT_KEY_PROFILE_OWNER, true)
        if (!profileOwner) {
            binding.modifyIv.visibility = View.GONE
        }*/

        binding.deleteIv.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("프로필 삭제")
                .setMessage("프로필을 삭제하겠습니까?")
                .setNegativeButton("아니오") { _, _ -> }
                .setPositiveButton("예") { _, _ ->
                    val profileId = intent.getIntExtra(INTENT_KEY_PROFILE_ID, -1)
                    if (profileId == -1) return@setPositiveButton
                    vm.deleteProfile(profileId)
                }
                .show()
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
            binding.descTv.text = it.description
            it.preferKeywords?.forEachIndexed { index, s ->
                when (index) {
                    0 -> {
                        binding.chip1.text = s
                        binding.chip1.visibility = View.VISIBLE
                    }
                    1 -> {
                        binding.chip2.text = s
                        binding.chip2.visibility = View.VISIBLE
                    }
                    2 -> {
                        binding.chip3.text = s
                        binding.chip3.visibility = View.VISIBLE
                    }
                }
            }

            it.preferChampions.forEachIndexed { index, preferChampion ->

                val champion = ChampionList.championNameList.find {
                    it.name_kr == preferChampion.championName
                }
                val resourceId = binding.root.context.resources.getIdentifier(champion?.name?.toLowerCase(), "drawable", binding.root.context.packageName)

                val levelResourceId = binding.root.context.resources.getIdentifier("champion_mastery_level_${preferChampion.championLevel}", "drawable", binding.root.context.packageName)

                when (index) {
                    0 -> {
                        binding.championImgCl01.setBackgroundResource(levelResourceId)
                        binding.championImg01.setImageResource(resourceId)
                        binding.championTv01.text = preferChampion.championName
                        binding.championPointTv01.text = preferChampion.championPoints
                        binding.championImgCl01.visibility = View.VISIBLE
                        binding.championTv01.visibility = View.VISIBLE
                        binding.championPointTv01.visibility = View.VISIBLE
                    }
                    1 -> {
                        binding.championImgCl02.setBackgroundResource(levelResourceId)
                        binding.championImg02.setImageResource(resourceId)
                        binding.championTv02.text = preferChampion.championName
                        binding.championPointTv02.text = preferChampion.championPoints
                        binding.championImgCl02.visibility = View.VISIBLE
                        binding.championTv02.visibility = View.VISIBLE
                        binding.championPointTv02.visibility = View.VISIBLE
                    }
                    2 -> {
                        binding.championImgCl03.setBackgroundResource(levelResourceId)
                        binding.championImg03.setImageResource(resourceId)
                        binding.championTv03.text = preferChampion.championName
                        binding.championPointTv03.text = preferChampion.championPoints
                        binding.championImgCl03.visibility = View.VISIBLE
                        binding.championTv03.visibility = View.VISIBLE
                        binding.championPointTv03.visibility = View.VISIBLE
                    }
                }
            }
        })

        vm.isDeleted.observe(this) {
            if (it) {
                Toast.makeText(this, "프로필 삭제 성공", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "프로필 삭제 실패", Toast.LENGTH_SHORT).show()
            }
        }
    }
}