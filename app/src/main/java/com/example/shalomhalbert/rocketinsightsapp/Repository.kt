package com.example.shalomhalbert.rocketinsightsapp

import androidx.lifecycle.MutableLiveData
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

object Repository {
    private val TAG: String = Repository::class.java.simpleName
    private val client by lazy {
        RetrofitGenerator.createService(Service::class.java)
    }

    suspend fun getDates(liveData: MutableLiveData<List<Date>>) {
        withContext(Dispatchers.IO) {
            try {
                val result = client.dates().await()
                liveData.postValue(result)
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException code: ${e.code()}")
            } catch (e: Throwable) {
                Log.e(TAG, "dates() failed-- " +
                        "Cause: ${e.cause}, Message: ${e.message}")
                throw e
            }
        }
    }
}