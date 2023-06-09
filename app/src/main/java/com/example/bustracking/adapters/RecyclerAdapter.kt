package com.example.bustracking.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bustracking.R
import com.example.bustracking.modals.RVBusDriverModal

class RecyclerAdapter(private val rvBusDriverModalArrayList: ArrayList<RVBusDriverModal>, val recyclerAdapterInterface: RecyclerAdapterInterface) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_bus_drivers, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvBusName.text = rvBusDriverModalArrayList[position].userName
        holder.itemView.setOnClickListener {
            recyclerAdapterInterface.onBusClick(position)
        }
    }

    override fun getItemCount(): Int {
        return rvBusDriverModalArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvBusName: TextView

        init {
            tvBusName = itemView.findViewById(R.id.tvBusName)
        }
    }

    interface RecyclerAdapterInterface {
        fun onBusClick(position: Int)
    }
}