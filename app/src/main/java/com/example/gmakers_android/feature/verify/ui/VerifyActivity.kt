package com.example.gmakers_android.feature.verify.ui

import android.os.Bundle
import android.view.View
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.data.model.ProfileDetail
import com.example.gmakers_android.databinding.ActivityVerifyBinding
import com.example.gmakers_android.feature.verify.viewmodel.VerifyViewModel
import com.example.gmakers_android.util.ImageMappingUtil

class VerifyActivity : BaseActivity<ActivityVerifyBinding>(R.layout.activity_verify) {

    override val vm: VerifyViewModel = VerifyViewModel()

    companion object {
        const val INTENT_KEY_PROFILE = "intent_key_profile"
    }

    val profile: ProfileDetail? by lazy {
        intent.getParcelableExtra(INTENT_KEY_PROFILE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // observe
        initObserver()

        // listener
        binding.backIv.setOnClickListener {
            finish()
        }

        binding.refreshTv.setOnClickListener {
            vm.getAuthProfileIconId(profile!!.summonerId)
        }

        binding.changeTv.setOnClickListener {
            vm.getAuthConfirmed(profile!!.summonerId)
        }

        binding.okTv.setOnClickListener {
            finish()
        }

        // first init
        vm.getAuthProfileIconId(profile!!.summonerId)
    }

    private fun initObserver() {
        vm.status.observe(this, {
            when (it) {
                VerifyViewModel.VerifyStatus.INIT -> {
                    binding.confirmingTv.visibility = View.GONE
                    binding.changeTv.visibility = View.VISIBLE
                    binding.failMsgTv.visibility = View.GONE
                }
                VerifyViewModel.VerifyStatus.CONFIRMING -> {
                    binding.confirmingTv.visibility = View.VISIBLE
                    binding.changeTv.visibility = View.GONE
                    binding.failMsgTv.visibility = View.GONE
                }
                VerifyViewModel.VerifyStatus.FAIL -> {
                    binding.confirmingTv.visibility = View.GONE
                    binding.changeTv.visibility = View.VISIBLE
                    binding.failMsgTv.visibility = View.VISIBLE
                }
                VerifyViewModel.VerifyStatus.SUCCESS -> {
                    binding.successLl.visibility = View.VISIBLE

                    binding.profileCardView.tier = profile!!.tier ?: "NONE"
                    binding.profileCardView.level = profile!!.level.toString()
                    binding.profileCardView.summonerName = profile!!.summonerName

                    binding.profileCardView.tierEmblem = ImageMappingUtil.getEmblemImageResource(profile!!.tier ?: "NONE")

                    profile!!.preferLines.forEachIndexed { index, preferLine ->
                        when (index) {
                            0 -> binding.profileCardView.lane01 = ImageMappingUtil.getPositionImageResource(preferLine.line)
                            1 -> binding.profileCardView.lane02 = ImageMappingUtil.getPositionImageResource(preferLine.line)
                        }
                    }

                    binding.profileCardView.verified = true
                }
            }
        })

        vm.profileIconId.observe(this, {
            val imageFileName = "img_profile_icon_${it}"
            binding.profileIconIv.setImageResource(resources.getIdentifier(imageFileName, "drawable", packageName))
        })
    }
}