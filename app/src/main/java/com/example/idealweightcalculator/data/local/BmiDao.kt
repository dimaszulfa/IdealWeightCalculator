package com.example.idealweightcalculator.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.*
import com.example.idealweightcalculator.data.BodyMassItem

@Dao
interface BmiDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(bmi: BodyMassItem)

    @Query("SELECT * FROM bmi ORDER by name ASC ")
     fun getAllBMI(): List<BodyMassItem>

     @Query("SELECT * from bmi where isFavorite = 1")
     fun getFavorite(): List<BodyMassItem>

     @Update
     fun setFavorite(bmi: BodyMassItem)





}