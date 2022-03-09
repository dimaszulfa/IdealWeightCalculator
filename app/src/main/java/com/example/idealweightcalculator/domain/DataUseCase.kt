package com.example.idealweightcalculator.domain

import androidx.lifecycle.LiveData
import com.example.idealweightcalculator.data.BodyMassItem

interface DataUseCase {
    suspend fun getCalculate(name: String, height: String, weight: String): BodyMass
    suspend fun getAllBmi(): List<BodyMass>
    suspend fun addBmi(bodyMass: BodyMass)
}