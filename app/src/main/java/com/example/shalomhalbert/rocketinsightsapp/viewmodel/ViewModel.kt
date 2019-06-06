package com.example.shalomhalbert.rocketinsightsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shalomhalbert.rocketinsightsapp.model.Date
import com.example.shalomhalbert.rocketinsightsapp.model.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {
    private val viewModelJob = Job()
    private val uiScope =
            CoroutineScope(Dispatchers.Main + viewModelJob)

    val dates = MutableLiveData<List<Date>>()

    init {
        uiScope.launch {
            dates.postValue(repository.getDates())
        }
    }
}