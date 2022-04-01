package com.example.idealweightcalculator.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.idealweightcalculator.data.BodyMassItem
import com.example.idealweightcalculator.data.FavoriteEntity

@Database(entities = [BodyMassItem::class, FavoriteEntity::class], version = 1, exportSchema = false)
abstract class BmiRoomDatabase : RoomDatabase(){
    abstract  fun BmiDao(): BmiDao
    abstract  fun FavoriteDao(): FavoriteDao
}