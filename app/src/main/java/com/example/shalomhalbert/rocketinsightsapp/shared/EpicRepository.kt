package com.example.shalomhalbert.rocketinsightsapp.shared

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

//Todo: Simplify and add deferred implementation

object EpicRepository {
    private val TAG: String = EpicRepository::class.java.simpleName
    private val dateClient by lazy { RetrofitGenerator.createDateService(DateService::class.java) }
    private val coroutineDateClient by lazy { RetrofitGenerator.createCoroutineDateService(DateService::class.java) }

    fun getDates(liveData: MutableLiveData<List<Date>>) {
        dateClient.dates().enqueue(object : Callback<List<Date>> {
            override fun onResponse(call: Call<List<Date>>, response: Response<List<Date>>) {
                when (response.isSuccessful) {
                    true -> liveData.postValue(response.body())
                    false -> Log.e(TAG, "Request error code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Date>>, t: Throwable) {
                Log.e(TAG, "getDates failed")
                throw t
            }
        })
    }

    suspend fun getDeferredDates(liveData: MutableLiveData<List<Date>>) {
        //Todo: Required to run off of the Main thread that's used by ViewModel scope
        withContext(Dispatchers.IO) {
            try {
                val result = coroutineDateClient.deferredDates().await()
                liveData.postValue(result)
            } catch (e: HttpException) {
                //Catch Http errors. Equivalent to "!response.isSuccessful"
                Log.e(TAG, "HttpException code: ${e.code()}")
            } catch (e: Throwable) {
                //Catch all other exceptions. Equivalent to "onFailure()"
                Log.e(TAG, "deferredDates() failed-- Cause: ${e.cause} \t Message: ${e.message}")
                throw e
            }
        }
    }
}