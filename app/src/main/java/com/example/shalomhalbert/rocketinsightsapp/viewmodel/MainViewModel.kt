package com.example.shalomhalbert.rocketinsightsapp.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.shalomhalbert.rocketinsightsapp.model.Date
import com.example.shalomhalbert.rocketinsightsapp.model.Repository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel(private val repository: Repository,
                    private val baseCoroutineDispatcher: CoroutineDispatcher) : ViewModel(),
                                                                                CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = baseCoroutineDispatcher + viewModelJob

    private val viewModelJob = Job()

    val dates = ObservableField<List<Date>>()

    fun onUpdateList() = launch { dates.set(repository.getDates()) }
}