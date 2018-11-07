package com.example.shalomhalbert.rocketinsightsapp.old

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OldRetrofitGenerator {
    private const val BASE_URL = "https://epic.gsfc.nasa.gov/"
    private val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

    fun <S: OldService> createDateService(service: Class<S>): S = retrofitBuilder
            .build().create(service)
}