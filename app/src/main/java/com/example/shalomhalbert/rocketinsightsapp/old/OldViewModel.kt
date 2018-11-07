package com.example.shalomhalbert.rocketinsightsapp.old

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shalomhalbert.rocketinsightsapp.shared.Date

class OldViewModel : ViewModel() {
    private val _dates = MutableLiveData<List<Date>>()
    val dates: LiveData<List<Date>>
        get() = _dates


    fun refreshDates() {
        OldRepository.getDates(_dates)
    }

}