package com.muratcakin.weatherapp.data.models

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("temp")
    val temp: Double?,
    @SerializedName("weather")
    val weather: Weather?
)
