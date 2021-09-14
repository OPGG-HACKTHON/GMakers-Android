package com.example.gmakers_android.feature.profile.ui


import android.content.Intent
import android.os.Bundle
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityEditProfileFinishBinding
import com.example.gmakers_android.feature.main.ui.MainActivity
import com.example.gmakers_android.feature.profile.viewmodel.EditProfileFinishViewModel
import com.example.gmakers_android.feature.verify.ui.VerifyActivity
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

        binding.backImg.setOnClickListener {
            startMainActivity()
        }

        binding.nextBtn.setOnClickListener {
            startMainActivity()
        }

        binding.certificationBtn.setOnClickListener {
            vm.profileDetail.value?.let {
                val intent = Intent(this, VerifyActivity::class.java)
                intent.putExtra(VerifyActivity.INTENT_KEY_PROFILE, it)
                startActivity(intent)
            }
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
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

            vm.getDetailProfile(profile.profileId)
        })

        vm.profileDetail.observe(this) {
            binding.certificationBtn.isEnabled = true
        }
    }
}