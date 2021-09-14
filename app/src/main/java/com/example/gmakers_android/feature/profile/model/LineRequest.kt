package com.example.gmakers_android.feature.profile.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LineRequest(val priority: Int, var line: String,val nullable: Boolean): Parcelable
