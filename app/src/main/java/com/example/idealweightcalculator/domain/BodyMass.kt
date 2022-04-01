package com.example.idealweightcalculator.domain

import com.example.idealweightcalculator.data.BodyMassItem
import java.util.*

data class BodyMass (
    var id: String = UUID.randomUUID().toString(),
    var name: String,
    var BMI: Double,
    var status: String,
    var isFavorite: Boolean
        ){
    fun toBodyMassItem() : BodyMassItem{
        return BodyMassItem(name=name,BMI=BMI, status=status,isFavorite = isFavorite)
    }
    fun toFavorite(): Favorite{
        return Favorite(id,name?:"name", BMI?:0.0, status ?: "status")
    }
}