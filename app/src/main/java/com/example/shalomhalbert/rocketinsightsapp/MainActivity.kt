package com.example.shalomhalbert.rocketinsightsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_day_list.*

/**
 * Base activity for all fragments
 */

class MainActivity : AppCompatActivity() {

    //Todo: Inject
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_day_list)

        (recyclerView as RecyclerView).apply {

            layoutManager = LinearLayoutManager(context)
            adapter = DayAdapter()
        }

        viewModel.dates.observe(this, Observer {
            val adapter = recyclerView.adapter as DayAdapter
            adapter.addDates(it)
        })

    }

}
