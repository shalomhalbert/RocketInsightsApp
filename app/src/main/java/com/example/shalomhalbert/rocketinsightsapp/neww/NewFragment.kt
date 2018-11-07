package com.example.shalomhalbert.rocketinsightsapp.neww

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shalomhalbert.rocketinsightsapp.R
import com.example.shalomhalbert.rocketinsightsapp.shared.DayAdapter
import com.example.shalomhalbert.rocketinsightsapp.shared.Date
import kotlinx.android.synthetic.main.fragment_day_list.*

class NewFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(NewViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = layoutInflater.inflate(R.layout.fragment_day_list, container,
            false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DayAdapter()
        }

        datesSubscription()
    }

    private fun datesSubscription() {
        viewModel.dates.observe(this, Observer<List<Date>> { dates ->
            dates?.let {
                val adapter = recyclerView.adapter as DayAdapter
                adapter.addDates(it)
            }
        })
        viewModel.refreshDates()
    }
}