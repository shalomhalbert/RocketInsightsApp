package com.example.shalomhalbert.rocketinsightsapp.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.shalomhalbert.rocketinsightsapp.Repository.EpicRepository
import com.example.shalomhalbert.rocketinsightsapp.models.Date

/**
 * [ViewModel] for [DayList]
 */
class DayListViewModel: ViewModel() {
    lateinit var dates: LiveData<List<Date>>

    init {
        refreshDates()
    }

    fun refreshDates() {
        dates = EpicRepository.getDates()
    }
}