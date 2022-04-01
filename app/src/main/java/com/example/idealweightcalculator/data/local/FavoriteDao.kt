package com.example.idealweightcalculator.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.idealweightcalculator.data.FavoriteEntity

@Dao
interface FavoriteDao {

    @Query("SELECT * from favorite ORDER by name ASC")
    fun getAllFavorite(): List<FavoriteEntity>

    @Insert
    fun addtoFavorite(favorite: FavoriteEntity)

    @Delete
    fun deleteFav(favorite: FavoriteEntity)
}