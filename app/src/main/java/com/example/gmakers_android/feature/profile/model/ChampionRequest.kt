package com.example.gmakers_android.feature.profile.model

import android.os.Parcelable
import androidx.annotation.Nullable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChampionRequest(val priority: Int, val championId: Int, val nullable: Boolean):
    Parcelable
