package com.sample.simpsonsviewer.SimpsonModel

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@kotlinx.parcelize.Parcelize
data class SimpsonsData(

    @Json(name = "RelatedTopics")
    val RelatedTopics: List<RelatedTopic>,
) : Parcelable