package hr.foi.air.osobnenavike.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface NavikeDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun dodajNaviku (navike: Navike)

    @Query(value = "SELECT * FROM navike_tablica ORDER BY id ASC")
    fun listaNavika():LiveData<List<Navike>>
}