package hr.foi.air.osobnenavike.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "navike_tablica")
data class Navike(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val nazivNavike: String,
    val tipNavike: String

)