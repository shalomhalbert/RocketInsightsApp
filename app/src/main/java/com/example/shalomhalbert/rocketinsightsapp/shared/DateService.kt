package com.example.shalomhalbert.rocketinsightsapp.shared

import com.example.shalomhalbert.rocketinsightsapp.shared.Date
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface DateService {
    //Regular request
    @GET("api/enhanced/all")
    fun dates(): Call<List<Date>>

    //Coroutine request
    @GET("api/enhanced/all")
    fun deferredDates(): Deferred<List<Date>>
}