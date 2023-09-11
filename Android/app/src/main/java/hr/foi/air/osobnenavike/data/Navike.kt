package hr.foi.air.osobnenavike.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "navike_tablica")
data class Navike(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val nazivNavike: String,
    val tipNavike: String

) : Parcelable