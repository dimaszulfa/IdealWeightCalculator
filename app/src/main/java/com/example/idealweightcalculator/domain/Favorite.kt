package com.example.idealweightcalculator.domain

import com.example.idealweightcalculator.data.FavoriteEntity


data class Favorite(
    var id: String,
    var name: String,
    var BMI: Double,
    var status: String,
){
    fun toFavoriteEntity() : FavoriteEntity{
        return FavoriteEntity(name=name, BMI = BMI, status = status, id = id)
    }
    fun toBodyMass() : BodyMass{
        return BodyMass(name=name, BMI = BMI, status = status,isFavorite = true)
    }
}
