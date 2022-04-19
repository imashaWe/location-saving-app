package com.imasha.locationserver.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.imasha.locationserver.R
import com.imasha.locationserver.models.LocationData

class LocationListAdapter :
    RecyclerView.Adapter<LocationListAdapter.ViewHolder>() {
    private var dataset: List<LocationData> = emptyList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.titleText)
        val listTitle: LinearLayout = view.findViewById(R.id.listTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_title, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataset[position]
        holder.title.text = data.name
        val bundle = Bundle()
        bundle.putString("locationName", data.name)
        bundle.putDouble("latitude", data.latitude!!)
        bundle.putDouble("longitude", data.longitude!!)
        holder.listTitle.setOnClickListener {
            it.findNavController().navigate(R.id.action_HomeFragment_to_mapViewFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun setData(data: List<LocationData>) {
        this.dataset = data
        notifyDataSetChanged()
    }
}