package com.example.idealweightcalculator.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.idealweightcalculator.data.BodyMassItem

@Database(entities = [BodyMassItem::class], version = 1, exportSchema = true)
abstract class BmiRoomDatabase : RoomDatabase(){
    abstract  fun BmiDao(): BmiDao
}