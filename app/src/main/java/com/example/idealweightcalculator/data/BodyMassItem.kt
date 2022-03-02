package com.example.idealweightcalculator.data

import com.example.idealweightcalculator.domain.BodyMass


data class BodyMassItem(
    var BMI: Double?,
    var status: String?
){
    fun toBodyMass(): BodyMass {
        return BodyMass(BMI ?: 0.0, status ?: "Status")
    }
}
