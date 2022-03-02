package com.example.idealweightcalculator.data

class BodyMassTesting : BodyMassRepository {
    override fun getDataFromSource(height: Double, weight: Double): BodyMassItem {
        return BodyMassItem(20.0, "Normal")
    }
}