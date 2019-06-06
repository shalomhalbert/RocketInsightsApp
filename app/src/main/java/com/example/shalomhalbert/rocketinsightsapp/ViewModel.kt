package com.example.shalomhalbert.rocketinsightsapp

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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