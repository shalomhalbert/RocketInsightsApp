package com.example.shalomhalbert.rocketinsightsapp.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.shalomhalbert.rocketinsightsapp.R
import com.example.shalomhalbert.rocketinsightsapp.models.Date
import kotlinx.android.synthetic.main.rv_day_list_item.view.*

/**
 * [RecyclerView.Adapter] for [HomeFragment]'s RecyclerView
 */

class DayListRecyclerViewAdapter() : RecyclerView.Adapter<DayListRecyclerViewAdapter.DayListViewHolder>() {
    var dates: List<Date>? = listOf()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DayListViewHolder =
            DayListViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.rv_day_list_item, p0, false))

    override fun onBindViewHolder(p0: DayListViewHolder, p1: Int) {
        p0.dateTextView.text = dates!![p1].date
    }

    override fun getItemCount(): Int = dates!!.size

    fun addDates(dates: List<Date>?) {
        this.dates = dates
        notifyDataSetChanged()
    }

    /**
     * [RecyclerView.ViewHolder] Class for [DayListRecyclerViewAdapter]
     */
    class DayListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.dateTextView
    }
}