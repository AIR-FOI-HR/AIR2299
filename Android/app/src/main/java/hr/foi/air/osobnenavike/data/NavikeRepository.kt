package hr.foi.air.osobnenavike.data

import androidx.lifecycle.LiveData

class NavikeRepository(private val navikeDao: NavikeDao) {

    val listaNavika: LiveData<List<Navike>> = navikeDao.listaNavika()

    suspend fun dodajNaviku(navike: Navike){
        navikeDao.dodajNaviku(navike)
    }
}