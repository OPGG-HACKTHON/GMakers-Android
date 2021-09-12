package com.example.gmakers_android.feature.profile.ui


import android.os.Bundle
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityEditProfileFinishBinding
import com.example.gmakers_android.feature.detail.ui.ProfileDetailActivity
import com.example.gmakers_android.feature.profile.viewmodel.EditProfileViewModel
import com.example.gmakers_android.util.ImageMappingUtil

class EditProfileFinishActivity :
    BaseActivity<ActivityEditProfileFinishBinding>(R.layout.activity_edit_profile_finish) {

    override val vm: EditProfileViewModel = EditProfileViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        certification()
        nextCertification()

    }

    override fun onStart() {
        super.onStart()

        inputData()
    }

    fun certification() {
        binding.certificationBtn.setOnClickListener {
            //TO DO
        }
    }

    fun nextCertification() {
        binding.nextBtn.setOnClickListener {
            //TO DO
        }
    }


    private fun inputData() {
        vm.run {
            vm.profile.observe(this@EditProfileFinishActivity, {

                binding.levelTv.text = it.level.toString()
                binding.summonerNameTv.text = it.summonerName
                binding.summonerNameTv.text = it.summonerName
                binding.tierIv.setImageResource(
                    ImageMappingUtil.getEmblemImageResource(
                        it.tier ?: "NONE"
                    )
                )
                binding.tierTv.text = it.tier ?: "NONE"
                it.preferLines.forEachIndexed { index, preferLine ->
                    when (index) {
                        0 -> binding.lane01Iv.setImageResource(
                            ImageMappingUtil.getPositionImageResource(
                                preferLine.line
                            )
                        )
                        1 -> binding.lane02Iv.setImageResource(
                            ImageMappingUtil.getPositionImageResource(
                                preferLine.line
                            )
                        )
                    }
                }
            })
        }
    }
}