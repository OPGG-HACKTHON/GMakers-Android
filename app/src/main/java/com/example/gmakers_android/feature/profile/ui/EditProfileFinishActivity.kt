package com.example.gmakers_android.feature.profile.ui


import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityEditProfileFinishBinding
import com.example.gmakers_android.feature.detail.ui.ProfileDetailActivity
import com.example.gmakers_android.feature.detail.viewmodel.ProfileDetailViewModel
import com.example.gmakers_android.feature.profile.model.LineRequest
import com.example.gmakers_android.feature.profile.viewmodel.EditProfileViewModel
import com.example.gmakers_android.feature.profile.viewmodel.PickChampionViewModel
import com.example.gmakers_android.feature.verify.ui.VerifyActivity
import com.example.gmakers_android.util.ImageMappingUtil
import com.google.android.material.chip.Chip

class EditProfileFinishActivity :
    BaseActivity<ActivityEditProfileFinishBinding>(R.layout.activity_edit_profile_finish) {

    override val vm: ProfileDetailViewModel = ProfileDetailViewModel()

    companion object {
        const val KEY_USER_NAME = "key_user_name"
        const val KEY_LINE = "key_line"
        const val KEY_RANK = "key_rank"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initObserver()

    }

    override fun onStart() {
        super.onStart()
    }

    private fun initObserver() {
        vm.profile.observe(this, {
            // profile card
            binding.tierTv
            binding.levelTv.text = it.level.toString()
            binding.summonerNameTv.text = it.summonerName
//            binding.tierIv.setImageDrawable() =
//                ImageMappingUtil.getEmblemImageResource(it.tier ?: "NONE")
//            it.preferLines.forEachIndexed { index, preferLine ->
//                when (index) {
//                    0 -> binding.profileView.lane01 =
//                        ImageMappingUtil.getPositionImageResource(preferLine.line)
//                    1 -> binding.profileView.lane02 =
//                        ImageMappingUtil.getPositionImageResource(preferLine.line)
//                }
//            }
        })
    }
}