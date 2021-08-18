package com.example.gmakers_android.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import com.example.gmakers_android.R
import com.example.gmakers_android.databinding.ViewProfileCardBinding

class ProfileCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
):FrameLayout(context, attrs, defStyleAttr) {

    var binding: ViewProfileCardBinding =
        DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_profile_card, this, false)

    init {
        addView(binding.root)
    }

    var tier: String
        get() = binding.tierTv.text.toString()
        set(value) {
            binding.tierTv.text = value
        }

    var tierEmblem: Int = 0
        set(value) {
            binding.tierIv.setImageResource(value)
            field = value
        }

    var level: String
        get() = binding.levelTv.text.toString()
        set(value) {
            binding.levelTv.text = value
        }

    var summonerName: String
        get() = binding.summonerNameTv.text.toString()
        set(value) {
            binding.summonerNameTv.text = value
        }

    var lane01: Int = 0
        set(value) {
            binding.lane01Iv.setImageResource(value)
        }

    var lane02: Int = 0
        set(value) {
            binding.lane02Iv.setImageResource(value)
        }
}