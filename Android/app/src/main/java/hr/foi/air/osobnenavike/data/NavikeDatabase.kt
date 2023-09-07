package hr.foi.air.osobnenavike.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Navike::class], version = 1, exportSchema = false)
abstract class NavikeDatabase: RoomDatabase() {
    abstract fun navikeDao():NavikeDao

    companion object{
        @Volatile
        private var INSTANCE:NavikeDatabase?=null

        fun getDatabase(context: Context):NavikeDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized( this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NavikeDatabase::class.java,
                    "navike_tablica"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}