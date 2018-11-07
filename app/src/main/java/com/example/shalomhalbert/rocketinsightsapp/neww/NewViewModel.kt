package com.example.shalomhalbert.rocketinsightsapp.neww

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.shalomhalbert.rocketinsightsapp.old.OldRepository
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
            NewRepository.getDeferredDates(_dates)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}