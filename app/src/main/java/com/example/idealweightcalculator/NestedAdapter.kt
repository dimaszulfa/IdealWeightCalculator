package com.example.idealweightcalculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.idealweightcalculator.domain.BodyMass

class NestedAdapter(val onFavorite: (BodyMass)->Unit) : RecyclerView.Adapter<NestedAdapter.ViewHolder>() {
    private val list = ArrayList<BodyMass>()
    var context: Context ?= null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById(R.id.tv_name) as TextView
        val bmi = itemView.findViewById(R.id.tv_bmi) as TextView
        val status = itemView.findViewById(R.id.tv_status) as TextView
        val btnFav = itemView.findViewById(R.id.btnFav) as ImageButton
        
        fun init(body: BodyMass){
            if(body.isFavorite){
                btnFav.setImageResource(R.drawable.ic_baseline_favorite_24)
            }else{
                btnFav.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_bmi, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = list[position]
        with(holder) {
            name.text = list.name
            bmi.text = list.BMI.toString()
            status.text = list.status
            
            holder.init(list)
            
            btnFav.setOnClickListener {
                if(!list.isFavorite){
                    btnFav.setImageResource(R.drawable.ic_baseline_favorite_24)
                    Toast.makeText(it.context,"to Favorite",Toast.LENGTH_SHORT).show()
                }else{
                    btnFav.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                    Toast.makeText(it.context,"unfavorite",Toast.LENGTH_SHORT).show()
                }
                list.isFavorite = !list.isFavorite
                onFavorite(list)

            }
        }

    }

    override fun getItemCount(): Int = list.size

    fun addData(data: List<BodyMass>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

}