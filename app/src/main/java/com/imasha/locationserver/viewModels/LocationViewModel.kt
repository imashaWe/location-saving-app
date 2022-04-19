package com.imasha.locationserver.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.imasha.locationserver.database.AppDatabase
import com.imasha.locationserver.models.LocationData
import com.imasha.locationserver.repository.LocationDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocationViewModel(application: Application) : AndroidViewModel(application) {

    private val database by lazy { AppDatabase.getDatabase(application.applicationContext) }
    private val repository by lazy { LocationDataRepository(database.locationDao()) }

    fun addNewLocation(location: LocationData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.inset(location)
        }
    }
}