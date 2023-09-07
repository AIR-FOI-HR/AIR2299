package hr.foi.air.osobnenavike.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NavikeViewModel(application: Application): AndroidViewModel(application) {
    private val listaNavika: LiveData<List<Navike>>
    private val repository: NavikeRepository

    init {
        val navikeDao = NavikeDatabase.getDatabase(application).navikeDao()
        repository= NavikeRepository(navikeDao)
        listaNavika=repository.listaNavika
    }
    fun dodajNaviku(navike: Navike){
        viewModelScope.launch(Dispatchers.IO) {
            repository.dodajNaviku(navike)
        }
    }
}