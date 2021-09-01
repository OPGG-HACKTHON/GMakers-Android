package com.example.gmakers_android.util

import com.example.gmakers_android.R

object ImageMappingUtil {

    fun getPositionImageResource(position: String): Int {
        return when (position) {
            "TOP" -> R.drawable.img_position_top
            "JUNGLE" -> R.drawable.img_position_jungle
            "MID" -> R.drawable.img_position_mid
            "AD" -> R.drawable.img_position_bottom
            "SUP" -> R.drawable.img_position_support
            else -> R.drawable.img_position_mid
        }
    }

    fun getEmblemImageResource(tier: String): Int {
        return when (tier) {
            "CHALLENGER" -> R.drawable.img_emblem_challenger
            "GRANDMASTER" -> R.drawable.img_emblem_grandmaster
            "MASTER" -> R.drawable.img_emblem_master
            "DIAMOND" -> R.drawable.img_emblem_diamond
            "PLATINUM" -> R.drawable.img_emblem_platinum
            "GOLD" -> R.drawable.img_emblem_gold
            "SILVER" -> R.drawable.img_emblem_silver
            "BRONZE" -> R.drawable.img_emblem_bronze
            "IRON" -> R.drawable.img_emblem_iron
            "NONE" -> R.drawable.img_emblem_iron
            else -> R.drawable.img_emblem_iron
        }
    }
}