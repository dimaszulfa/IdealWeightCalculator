package com.example.idealweightcalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.idealweightcalculator.data.BodyMassItem
import com.example.idealweightcalculator.domain.BodyMass

class NestedAdapter(): RecyclerView.Adapter<NestedAdapter.ViewHolder>() {
    private val list = ArrayList<BodyMass>()

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById(R.id.tv_name) as TextView
        val bmi = itemView.findViewById(R.id.tv_bmi) as TextView
        val status = itemView.findViewById(R.id.tv_status) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_bmi, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text = list[position].name
        holder.bmi.text = list[position].BMI.toString()
        holder.status.text = list[position].status
    }

    override fun getItemCount(): Int = list.size

    fun addData(data : List<BodyMass>){
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}