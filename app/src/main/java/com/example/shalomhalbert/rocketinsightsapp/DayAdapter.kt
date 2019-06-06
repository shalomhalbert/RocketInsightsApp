package com.example.shalomhalbert.rocketinsightsapp

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shalomhalbert.rocketinsightsapp.databinding.RvDayListItemBinding

class DayAdapter : RecyclerView.Adapter<DayAdapter.DayListViewHolder>() {
    private val dates = mutableListOf<Date>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvDayListItemBinding.inflate(inflater, parent, false)
        return DayListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DayListViewHolder, position: Int) {
        val date = dates[position].date
        holder.binding.date = date
    }

    override fun getItemCount(): Int = dates.size

    fun addDates(newDates: List<Date>) {
        dates.addAll(newDates)
        notifyDataSetChanged()
    }

    class DayListViewHolder(val binding: RvDayListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}