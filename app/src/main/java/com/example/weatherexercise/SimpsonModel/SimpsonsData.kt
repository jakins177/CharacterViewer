package com.example.weatherexercise.SimpsonModel

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.RawValue

@JsonClass(generateAdapter = true)
@kotlinx.parcelize.Parcelize
data class SimpsonsData(

    @Json(name = "RelatedTopics")
    val RelatedTopics: List<RelatedTopic>,
) : Parcelable