package com.example.idealweightcalculator.domain

import com.example.idealweightcalculator.data.BodyMassItem

data class BodyMass (
    var name: String,
    var BMI: Double,
    var status: String
        ){
    fun toBodyMassItem() : BodyMassItem{
        return BodyMassItem(name,BMI, status)
    }
}