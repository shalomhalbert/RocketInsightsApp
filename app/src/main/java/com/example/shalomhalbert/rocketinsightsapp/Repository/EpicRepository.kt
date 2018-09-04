package com.example.shalomhalbert.rocketinsightsapp.Repository

import android.accounts.NetworkErrorException
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.widget.Toast
import com.example.shalomhalbert.rocketinsightsapp.models.Date
import com.example.shalomhalbert.rocketinsightsapp.service.EpicServiceGenerator
import com.example.shalomhalbert.rocketinsightsapp.service.PhotoClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object EpicRepository {
    private val LOG_TAG = EpicRepository::class.java.simpleName

    private val dates: MutableLiveData<List<Date>> = MutableLiveData()

    val photoClient: PhotoClient = EpicServiceGenerator.createService(PhotoClient::class.java)

    fun getDates(): MutableLiveData<List<Date>> {
        photoClient.dates().enqueue(object : Callback<List<Date>>{
            override fun onFailure(call: Call<List<Date>>?, t: Throwable?) {
                throw Exception("getDates() failed")
            }

            override fun onResponse(call: Call<List<Date>>?, response: Response<List<Date>>?) {
                when(response!!.isSuccessful) {
                    true -> dates.postValue(response!!.body())
                    false -> Log.e(LOG_TAG, "Request error code: ${response!!.code()}")
                }
            }

        })
        return dates
    }

}