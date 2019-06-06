package com.example.shalomhalbert.rocketinsightsapp

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface NewService {
    @GET("api/enhanced/all")
    fun dates(): Deferred<List<Date>>
}