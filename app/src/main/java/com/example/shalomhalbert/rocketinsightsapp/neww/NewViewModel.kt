package com.example.shalomhalbert.rocketinsightsapp.neww

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shalomhalbert.rocketinsightsapp.shared.Date
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NewViewModel: ViewModel() {
    private val viewModelJob = Job()
    private val uiScope =
            CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _dates = MutableLiveData<List<Date>>()
    val dates: LiveData<List<Date>>
        get() = _dates


    fun refreshDates() {
        uiScope.launch {
            NewRepository.getDates(_dates)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}