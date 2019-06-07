package com.example.shalomhalbert.rocketinsightsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shalomhalbert.rocketinsightsapp.viewmodel.MainViewModel
import com.example.shalomhalbert.rocketinsightsapp.R
import kotlinx.android.synthetic.main.fragment_day_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_day_list)

        (recyclerView as RecyclerView).apply {

            layoutManager = LinearLayoutManager(context)
            adapter = DayAdapter()
        }

        viewModel.dates.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                val adapter = recyclerView.adapter as DayAdapter
                viewModel.dates.get()?.let { adapter.addDates(it) }
            }
        })

        viewModel.onUpdateList()

    }

}
