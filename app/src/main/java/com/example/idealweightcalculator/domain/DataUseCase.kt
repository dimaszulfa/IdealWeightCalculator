package com.example.idealweightcalculator.domain

interface DataUseCase {
    fun getCalculate(height: String, weight: String): BodyMass
}