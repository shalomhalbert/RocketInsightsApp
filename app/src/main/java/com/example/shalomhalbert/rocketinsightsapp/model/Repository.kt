package com.example.shalomhalbert.rocketinsightsapp.model

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class Repository (private val service: Service) {
    private val TAG: String = Repository::class.java.simpleName

    suspend fun getDates(): List<Date> =
         withContext(Dispatchers.IO) {
            try {
                service.dates().await()
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException code: ${e.code()}")
                emptyList<Date>()
            } catch (e: Throwable) {
                Log.e(TAG, "dates() failed-- " +
                        "Cause: ${e.cause}, Message: ${e.message}")
                throw e
            }
        }
}