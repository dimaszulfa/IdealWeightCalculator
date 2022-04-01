package com.example.idealweightcalculator.data

import androidx.lifecycle.LiveData
import com.example.idealweightcalculator.data.local.BmiDao
import com.example.idealweightcalculator.data.local.FavoriteDao

class   BodyMassDataStore(private val BmiDao: BmiDao, private val favorite: FavoriteDao) : BodyMassRepository{

    override suspend fun getDataFromSource(name: String,height: Double, weight: Double): BodyMassItem {
        var id = ""
        var imt = 0.0
        var status = ""
        var isFavorite = false
        var heightToMeter = (height.toDouble() / 100) * (height.toDouble() / 100)
        imt = weight.toDouble() / heightToMeter

        when {
            imt >= 0 && imt < 18.5 -> status = "UnderWeight"
            imt in 18.5..24.9 -> status = "Normal Weight"
            imt in 25.0..29.9 -> status = "Overweight"
            imt in 30.0..34.9 -> status = "Obesity class I"
            imt in 35.0..39.9 -> status = "Obesity Class I"
            imt >= 40.0 -> status = "Obesity class II"
            else -> {
                status = "Please enter correct data"
            }

        }
        return BodyMassItem (id, name, imt, status, isFavorite)
    }

    override suspend fun getAllBmi(): List<BodyMassItem> = BmiDao.getAllBMI()

    override suspend fun addBmi(bodyMass: BodyMassItem) {
        BmiDao.insert(bodyMass)
    }

    override suspend fun getFavorite(): List<FavoriteEntity> = favorite.getAllFavorite()

    override suspend fun addToFavorite(fav: FavoriteEntity) {
        favorite.addtoFavorite(fav)
    }

    override suspend fun setFavorite(bodyMass: BodyMassItem) = BmiDao.setFavorite(bodyMass)

    override suspend fun deleteFavorite(fav: FavoriteEntity) {
        favorite.deleteFav(fav)
    }
}


