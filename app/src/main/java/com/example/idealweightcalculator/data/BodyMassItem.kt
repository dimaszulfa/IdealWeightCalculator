package com.example.idealweightcalculator.data

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.idealweightcalculator.domain.BodyMass
import kotlinx.parcelize.Parcelize
import java.util.*


@Parcelize
@Entity(tableName = "bmi")
data class BodyMassItem(

    @PrimaryKey @NonNull @ColumnInfo(name = "id")
    var id: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "BMI")
    var BMI: Double?,

    @ColumnInfo(name = "status")
    var status: String?,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean?
) : Parcelable {
    fun toBodyMass(): BodyMass {
        return BodyMass(id?:id,name ?: "Name", BMI ?: 0.0, status ?: "status", isFavorite ?: false)
    }


}
