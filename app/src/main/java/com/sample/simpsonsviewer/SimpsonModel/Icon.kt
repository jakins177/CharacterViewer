package com.sample.simpsonsviewer.SimpsonModel

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Icon(
    @Json(name = "Height")
    val Height: String,
    @Json(name = "URL")
    val URL: String,
    @Json(name = "Width")
    val Width: String
) : Parcelable