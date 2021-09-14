package com.example.gmakers_android.feature.profile.ui


import android.os.Bundle
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityEditProfileFinishBinding
import com.example.gmakers_android.feature.profile.viewmodel.EditProfileFinishViewModel
import com.example.gmakers_android.util.ImageMappingUtil

class EditProfileFinishActivity :
    BaseActivity<ActivityEditProfileFinishBinding>(R.layout.activity_edit_profile_finish) {

    override val vm: EditProfileFinishViewModel = EditProfileFinishViewModel()

    companion object {
        const val KEY_USER_NAME = "key_user_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initObserver()

        val userName = intent.getStringExtra(KEY_USER_NAME)
        userName?.let {
            vm.getProfiles(userName)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    private fun initObserver() {
        vm.profile.observe(this, { profile ->
            binding.profileCardView.tier = profile.tier ?: "NONE"
            binding.profileCardView.level = profile.level.toString()
            binding.profileCardView.summonerName = profile.summonerName

            binding.profileCardView.tierEmblem = ImageMappingUtil.getEmblemImageResource(profile.tier ?: "NONE")

            profile.preferLines.forEachIndexed { index, preferLine ->
                when (index) {
                    0 -> binding.profileCardView.lane01 = ImageMappingUtil.getPositionImageResource(preferLine.line)
                    1 -> binding.profileCardView.lane02 = ImageMappingUtil.getPositionImageResource(preferLine.line)
                }
            }

            binding.profileCardView.verified = profile.certified
        })
    }
}