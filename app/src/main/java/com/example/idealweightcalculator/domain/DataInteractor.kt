package com.example.idealweightcalculator.domain

import com.example.idealweightcalculator.data.BodyMassRepository

class DataInteractor(private val dataRepository: BodyMassRepository) : DataUseCase{

    override fun getCalculate(height: String, weight: String): BodyMass {
        val item = dataRepository.getDataFromSource(height.toDouble(), weight.toDouble())
        return item.toBodyMass()
    }


}