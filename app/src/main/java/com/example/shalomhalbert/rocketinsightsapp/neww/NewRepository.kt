package com.example.shalomhalbert.rocketinsightsapp.neww

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.shalomhalbert.rocketinsightsapp.shared.Date
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

object NewRepository {
    private val TAG: String = NewRepository::class.java.simpleName
    private val client by lazy { NewRetrofitGenerator.createService(NewService::class.java) }

    suspend fun getDeferredDates(liveData: MutableLiveData<List<Date>>) {
        //Required to run off of the Main thread that's used by ViewModel scope
        withContext(Dispatchers.IO) {
            try {
                val result = client.deferredDates().await()
                liveData.postValue(result)
            } catch (e: HttpException) {
                //Catch Http errors. Equivalent to "!response.isSuccessful"
                Log.e(TAG, "HttpException code: ${e.code()}")
            } catch (e: Throwable) {
                //Catch all other exceptions. Equivalent to "onFailure()"
                Log.e(TAG, "deferredDates() failed-- Cause: ${e.cause}, Message: ${e.message}")
                throw e
            }
        }
    }
}