package com.example.idealweightcalculator.domain

import androidx.lifecycle.LiveData
import com.example.idealweightcalculator.data.BodyMassItem
import com.example.idealweightcalculator.data.FavoriteEntity

interface DataUseCase {
    suspend fun getCalculate(name: String, height: String, weight: String): BodyMass
    suspend fun getAllBmi(): List<BodyMass>
    suspend fun addBmi(bodyMass: BodyMass)
    suspend fun getFavorite(): List<Favorite>
    suspend fun addToFavorite(favorite: Favorite)
    suspend fun setFavorite(bodyMass: BodyMass)
    suspend fun deleteFav(fav: Favorite)

}