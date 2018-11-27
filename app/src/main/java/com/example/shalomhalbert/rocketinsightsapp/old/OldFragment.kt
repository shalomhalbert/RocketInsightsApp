package com.example.shalomhalbert.rocketinsightsapp.old

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shalomhalbert.rocketinsightsapp.R
import com.example.shalomhalbert.rocketinsightsapp.shared.DayAdapter
import com.example.shalomhalbert.rocketinsightsapp.shared.Date
import kotlinx.android.synthetic.main.fragment_day_list.*

class OldFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(OldViewModel::class.java)
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
        viewModel.dates.observe(viewLifecycleOwner, Observer<List<Date>> { dates ->
            dates?.let {
                val adapter = recyclerView.adapter as DayAdapter
                adapter.addDates(it)
            }
        })
        viewModel.refreshDates()
    }
}