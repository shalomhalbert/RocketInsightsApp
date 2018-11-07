package com.example.shalomhalbert.rocketinsightsapp.shared

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.shalomhalbert.rocketinsightsapp.R
import kotlinx.android.synthetic.main.rv_day_list_item.view.*

/**
 * [RecyclerView.Adapter] for [HomeFragment]'s RecyclerView
 */
//Todo: Cleanup, and create ViewModel parameter version to ask audience for opinions
class DayAdapter : RecyclerView.Adapter<DayAdapter.DayListViewHolder>() {
    private val dates = mutableListOf<Date>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DayListViewHolder =
            DayListViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.rv_day_list_item, p0, false))

    override fun onBindViewHolder(p0: DayListViewHolder, p1: Int) {
        p0.dateTextView.text = dates!![p1].date
    }

    override fun getItemCount(): Int = dates!!.size

    fun addDates(newDates: List<Date>) {
        dates.addAll(newDates)
        notifyDataSetChanged()
    }

    /**
     * [RecyclerView.ViewHolder] Class for [DayAdapter]
     */
    class DayListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.dateTextView
    }
}