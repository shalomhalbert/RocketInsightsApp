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
    /** This is the job for all coroutines started by this ViewModel. */
    private val viewModelJob = Job()
    /** This is the main scope for all coroutines launched by MainViewModel. */
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

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