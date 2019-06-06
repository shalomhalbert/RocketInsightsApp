package com.example.shalomhalbert.rocketinsightsapp.model

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitGenerator {
    private const val BASE_URL = "https://epic.gsfc.nasa.gov/"

    private val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

    val service = createService(Service::class.java)

    private fun <S: Service> createService(service: Class<S>): S = retrofitBuilder
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(service)


}