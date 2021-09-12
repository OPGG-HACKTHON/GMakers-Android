package com.example.gmakers_android.feature.profile.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EditProfileRequest(
    val summonerName: String,
    val description: String,
    val preferKeywords: List<String>,
    val preferChampions: List<ChampionRequest>,
    val preferLines: List<LineRequest>,
    val preferQueue: String
): Parcelable
