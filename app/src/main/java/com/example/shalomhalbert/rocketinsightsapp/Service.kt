package com.example.shalomhalbert.rocketinsightsapp

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface Service {
    @GET("api/enhanced/all")
    fun dates(): Deferred<List<Date>>
}