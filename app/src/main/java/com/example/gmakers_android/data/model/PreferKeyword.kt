package com.example.gmakers_android.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PreferKeyword(
    val keyword: String
): Parcelable
