package com.example.shalomhalbert.rocketinsightsapp.service

import com.example.shalomhalbert.rocketinsightsapp.models.Date
import retrofit2.Call
import retrofit2.http.GET

interface PhotoClient {
    @GET("api/enhanced/all")
    fun dates(): Call<List<Date>>
}