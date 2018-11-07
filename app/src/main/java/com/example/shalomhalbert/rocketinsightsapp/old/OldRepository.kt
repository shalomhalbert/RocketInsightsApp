package com.example.shalomhalbert.rocketinsightsapp.old

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.shalomhalbert.rocketinsightsapp.shared.Date
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

object OldRepository {
    private val TAG: String = OldRepository::class.java.simpleName
    private val client by lazy { OldRetrofitGenerator.createDateService(OldService::class.java) }

    fun getDates(liveData: MutableLiveData<List<Date>>) {
        client.dates().enqueue(object : Callback<List<Date>> {
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
}