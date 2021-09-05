package com.example.gmakers_android.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PreferChampion(
    val championId: Int,
    val championName: String,
    val championPoints: String,
    val preferChampionPriority: Int,
    val championLevel: Int
): Parcelable
