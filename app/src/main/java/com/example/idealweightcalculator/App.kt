package com.example.idealweightcalculator

import android.app.Application
import com.example.idealweightcalculator.di.BodyMassModule
import com.example.idealweightcalculator.di.dataBaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                dataBaseModule,
                BodyMassModule)
        }
    }
}