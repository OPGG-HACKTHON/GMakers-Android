package com.example.gmakers_android.data.model

data class ProfileDetail(
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
    val leaguePoint: Int,
    val loseGames: Int,
    val winGames: Int,
    val winRate: Int,
    val discription: String?,
    val preferChampions: List<PreferChampion>,
    val preferLines: List<PreferLine>,
    val preferKeyword: List<PreferKeyword>?,
    val certified: Boolean
)
