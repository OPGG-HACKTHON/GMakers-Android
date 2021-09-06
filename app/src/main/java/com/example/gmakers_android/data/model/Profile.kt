package com.example.gmakers_android.data.model

data class Profile(
    val accountId: Int,
    val username: String,
    val profileId: Int,
    val summonerAccountId: String,
    val profileIconId: Int,
    val summonerId: String,
    val summonerName: String,
    val preferQueue: String,
    val level: Int,
    val queue: String,
    val tier: String?,
    val tierLevel: Int,
    val preferLines: List<PreferLine>,
    val certified: Boolean
)