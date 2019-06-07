package com.example.shalomhalbert.rocketinsightsapp.model

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class Repository(private val service: Service) {
    private val TAG: String = Repository::class.java.simpleName

    //Removed Log because it causes problems that Timber would resolve, and I don't care to implement Timber
    suspend fun getDates(): List<Date> =
        withContext(Dispatchers.IO) {
            try {
                service.dates().await()
            } catch (e: HttpException) {
                emptyList<Date>()
            } catch (e: Throwable) {
                throw e
            }
        }
}