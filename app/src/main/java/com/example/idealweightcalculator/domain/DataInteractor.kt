package com.example.idealweightcalculator.domain

import com.example.idealweightcalculator.data.BodyMassItem
import com.example.idealweightcalculator.data.BodyMassRepository
import com.example.idealweightcalculator.data.FavoriteEntity

class DataInteractor(private val dataRepository: BodyMassRepository) : DataUseCase{

    override suspend fun getCalculate(name: String, height: String, weight: String): BodyMass {
        val item = dataRepository.getDataFromSource(name,height.toDouble(), weight.toDouble())
        return item.toBodyMass()
    }

    override suspend fun getAllBmi(): List<BodyMass> {

        val getFav = getFavorite().map {
            it.id
        }
        val item = dataRepository.getAllBmi().map{
            it.toBodyMass().let{
                if (getFav.contains(it.id)){
                    it.copy(isFavorite = true)
                }else{
                    it
                }
            }
        }
        return item

    }

    override suspend fun addBmi(bodyMass: BodyMass) {
        dataRepository.addBmi(bodyMass.toBodyMassItem())
    }

    override suspend fun getFavorite(): List<Favorite> {
       return dataRepository.getFavorite().map {
           it.toFavorite()
       }
    }

    override suspend fun addToFavorite(favorite: Favorite) {
        dataRepository.addToFavorite(favorite.toFavoriteEntity())
    }

    override suspend fun setFavorite(bodyMass: BodyMass) {
        dataRepository.setFavorite(bodyMass.toBodyMassItem())
    }

    override suspend fun deleteFav(fav: Favorite) {
        dataRepository.deleteFavorite(fav.toFavoriteEntity())
    }


}