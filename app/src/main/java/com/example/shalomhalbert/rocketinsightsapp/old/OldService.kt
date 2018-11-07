package com.example.shalomhalbert.rocketinsightsapp.old

import com.example.shalomhalbert.rocketinsightsapp.shared.Date
import retrofit2.Call
import retrofit2.http.GET

interface OldService {
    @GET("api/enhanced/all")
    fun dates(): Call<List<Date>>
}