package com.example.gmakers_android.feature.profile.model

data class EditProfileRequest(
    val summonerName: String,
    val description: String,
    val preferKeyword: String,
    val preferChampions: List<ChampionRequest>,
    val preferLines: List<LineRequest>,
    val preferQueue: String
)
