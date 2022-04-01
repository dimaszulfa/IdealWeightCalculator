package com.example.idealweightcalculator.di

import android.app.Application
import androidx.room.Room
import com.example.idealweightcalculator.data.BodyMassDataStore
import com.example.idealweightcalculator.data.BodyMassRepository
import com.example.idealweightcalculator.data.local.BmiDao
import com.example.idealweightcalculator.data.local.BmiRoomDatabase
import com.example.idealweightcalculator.domain.DataInteractor
import com.example.idealweightcalculator.domain.DataUseCase
import com.example.idealweightcalculator.presentation.MainViewModel
import com.example.idealweightcalculator.utils.DatabaseService.provideDao
import com.example.idealweightcalculator.utils.DatabaseService.provideDatabase
import com.example.idealweightcalculator.utils.DatabaseService.provideFav
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val dataBaseModule = module{

    single{provideDatabase((androidApplication()))}
    single{provideDao(get())}
    single{provideFav(get())}
}

val BodyMassModule = module {
    viewModel { MainViewModel(get())}
    single <DataUseCase>{ DataInteractor(get())}
    single <BodyMassRepository>{BodyMassDataStore(get(), get())}
}