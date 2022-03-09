package com.example.idealweightcalculator.utils

import android.app.Application
import androidx.room.Room
import com.example.idealweightcalculator.data.local.BmiDao
import com.example.idealweightcalculator.data.local.BmiRoomDatabase

object DatabaseService {
    fun provideDatabase(application: Application): BmiRoomDatabase {
        return Room.databaseBuilder(application, BmiRoomDatabase::class.java, "bmi")
            .fallbackToDestructiveMigration()
            .build()
    }
    fun provideDao(database: BmiRoomDatabase): BmiDao {
        return database.BmiDao()
    }
}