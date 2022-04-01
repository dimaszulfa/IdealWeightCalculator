package com.example.idealweightcalculator.data

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.idealweightcalculator.domain.Favorite
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "favorite")
data class FavoriteEntity(

    @PrimaryKey @NonNull @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "name")
    var name: String?,

    @ColumnInfo(name = "BMI")
    var BMI: Double?,

    @ColumnInfo(name = "status")
    var status: String?
) : Parcelable {
    fun toFavorite(): Favorite {
        return Favorite(name=name ?: "nama", BMI=BMI ?: 0.0, status=status ?: "status", id=id?:"")
    }
}