package com.example.shalomhalbert.rocketinsightsapp.model

import com.example.shalomhalbert.rocketinsightsapp.model.Date
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface Service {
    @GET("api/enhanced/all")
    fun dates(): Deferred<List<Date>>
}