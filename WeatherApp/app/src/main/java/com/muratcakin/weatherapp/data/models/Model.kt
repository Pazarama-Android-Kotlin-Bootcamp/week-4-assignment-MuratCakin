package com.muratcakin.weatherapp.data.models

import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("current")
    val current: Current?,
    @SerializedName("daily")
    val daily: Daily?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lon")
    val lon: Double?,
)