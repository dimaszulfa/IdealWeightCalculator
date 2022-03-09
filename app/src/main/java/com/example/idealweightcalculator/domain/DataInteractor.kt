package com.example.idealweightcalculator.domain

import com.example.idealweightcalculator.data.BodyMassItem
import com.example.idealweightcalculator.data.BodyMassRepository

class DataInteractor(private val dataRepository: BodyMassRepository) : DataUseCase{

    override suspend fun getCalculate(name: String, height: String, weight: String): BodyMass {
        val item = dataRepository.getDataFromSource(name,height.toDouble(), weight.toDouble())
        return item.toBodyMass()
    }

    override suspend fun getAllBmi(): List<BodyMass> {
        val item = dataRepository.getAllBmi().map{
            it.toBodyMass()
        }
        return item

    }

    override suspend fun addBmi(bodyMass: BodyMass) {
        dataRepository.addBmi(bodyMass.toBodyMassItem())
    }


}