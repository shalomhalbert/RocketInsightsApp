package com.example.shalomhalbert.rocketinsightsapp.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shalomhalbert.rocketinsightsapp.R
import com.example.shalomhalbert.rocketinsightsapp.adapters.DayListRecyclerViewAdapter
import com.example.shalomhalbert.rocketinsightsapp.models.Date
import com.example.shalomhalbert.rocketinsightsapp.viewmodels.DayListViewModel
import kotlinx.android.synthetic.main.fragment_day_list.*
import kotlinx.android.synthetic.main.fragment_day_list.view.*
import java.util.*

/**
 * Contains a list of dates for which image data is available
 */

class DayListFragment: Fragment() {

    companion object {
        val TAG = DayListFragment::class.java.simpleName
        fun newInstance() = DayListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = layoutInflater.inflate(R.layout.fragment_day_list, container, false)

        val viewModel = ViewModelProviders.of(this).get(DayListViewModel::class.java)

        view.dayListRecyclerView.apply {
            layoutManager = GridLayoutManager(this@DayListFragment.context, 2)
            adapter = DayListRecyclerViewAdapter()
        }

        viewModel.dates.observe(this, Observer<List<Date>> {
            val adapter = dayListRecyclerView.adapter as DayListRecyclerViewAdapter

            adapter.addDates(it)
        })

        return view
    }
}