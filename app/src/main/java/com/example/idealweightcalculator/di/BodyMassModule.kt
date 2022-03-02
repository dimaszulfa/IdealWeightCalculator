package com.example.idealweightcalculator.di

import com.example.idealweightcalculator.data.BodyMassDataStore
import com.example.idealweightcalculator.data.BodyMassItem
import com.example.idealweightcalculator.data.BodyMassRepository
import com.example.idealweightcalculator.data.BodyMassTesting
import com.example.idealweightcalculator.domain.BodyMass
import com.example.idealweightcalculator.domain.DataInteractor
import com.example.idealweightcalculator.domain.DataUseCase
import com.example.idealweightcalculator.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val BodyMassModule = module {
    viewModel { MainViewModel(get()) }
    single <DataUseCase>{ DataInteractor(get())}
    single <BodyMassRepository>{
        object : BodyMassRepository{
            override fun getDataFromSource(height: Double, weight: Double): BodyMassItem {
                TODO("Not yet implemented")
            }

        }
    }
    single <BodyMass>{BodyMass(10.0,"Overweight")}
}