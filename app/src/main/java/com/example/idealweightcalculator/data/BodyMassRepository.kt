package com.example.idealweightcalculator.data

import androidx.lifecycle.LiveData
import com.example.idealweightcalculator.domain.BodyMass

interface BodyMassRepository{
    suspend fun getDataFromSource(name: String,height: Double, weight: Double): BodyMassItem
    suspend fun getAllBmi(): List<BodyMassItem>
    suspend fun addBmi(bodyMass: BodyMassItem)
    suspend fun getFavorite(): List<FavoriteEntity>
    suspend fun addToFavorite(favorite: FavoriteEntity)
    suspend fun setFavorite(bodyMass: BodyMassItem)
    suspend fun deleteFavorite(favorite: FavoriteEntity)


}