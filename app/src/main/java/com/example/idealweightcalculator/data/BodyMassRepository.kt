package com.example.idealweightcalculator.data

import com.example.idealweightcalculator.domain.BodyMass

interface BodyMassRepository {
    fun getDataFromSource(height: Double, weight: Double): BodyMassItem
}

interface body2{
    fun getData()
}

class ImplementBody{
    fun init(){
        val body = object: BodyMassRepository{
            override fun getDataFromSource(height: Double, weight: Double): BodyMassItem {
                TODO("Not yet implemented")
            }

        }
    }

}