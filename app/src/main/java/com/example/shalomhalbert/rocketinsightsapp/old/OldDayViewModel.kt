package com.example.shalomhalbert.rocketinsightsapp.old

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.shalomhalbert.rocketinsightsapp.shared.EpicRepository
import com.example.shalomhalbert.rocketinsightsapp.shared.Date

class OldDayViewModel : ViewModel() {
    private val _dates = MutableLiveData<List<Date>>()
    val dates: LiveData<List<Date>>
        get() = _dates


    fun refreshDates() {
        EpicRepository.getDates(_dates)
    }

}