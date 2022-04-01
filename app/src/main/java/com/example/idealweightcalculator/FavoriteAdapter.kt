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
import com.example.idealweightcalculator.domain.Favorite

class FavoriteAdapter(var onFavorite: (Favorite)->Unit): RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
    private val list = ArrayList<Favorite>()
    var context: Context?= null

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        val name = itemView.findViewById(R.id.tv_name) as TextView
        val bmi = itemView.findViewById(R.id.tv_bmi) as TextView
        val status = itemView.findViewById(R.id.tv_status) as TextView
        val btnFav = itemView.findViewById(R.id.btnFav) as ImageButton

        fun initUI(){
                btnFav.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_bmi, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            initUI()
            name.text = list[position].name
            bmi.text = list[position].BMI.toString()
            status.text = list[position].status


            btnFav.setOnClickListener {
                    Toast.makeText(context,"UnFavorite", Toast.LENGTH_SHORT).show()
                    btnFav.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                    onFavorite(list[position])
            }
            }
        }

    override fun getItemCount(): Int = list.size

    fun addData(data: List<Favorite>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}


