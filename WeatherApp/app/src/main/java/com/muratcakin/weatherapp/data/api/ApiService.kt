package com.muratcakin.weatherapp.data.api


import com.muratcakin.weatherapp.data.models.Model
import com.muratcakin.weatherapp.data.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.REST_URL)
    fun getWeatherData(
        @Query("lat")
        lat: Double?,
        @Query("lon")
        lon: Double?,
        @Query("units")
        units: String? = "metrics"
    ): Call<List<Model>>
}