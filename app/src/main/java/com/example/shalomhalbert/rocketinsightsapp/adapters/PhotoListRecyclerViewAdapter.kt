package com.example.shalomhalbert.rocketinsightsapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.rv_photo_list_item.view.*

/**
 * [RecyclerView.Adapter] for [PhotoListFragment]'s RecyclerView
 */

class PhotoListRecyclerViewAdapter: RecyclerView.Adapter<PhotoListRecyclerViewAdapter.PhotoListViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PhotoListViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: PhotoListViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class PhotoListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val photoGridItem: ImageView = itemView.photoGridItem
    }


}