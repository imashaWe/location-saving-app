package com.imasha.locationserver.repository

import androidx.annotation.WorkerThread
import com.imasha.locationserver.database.LocationDao
import com.imasha.locationserver.models.LocationData
import kotlinx.coroutines.flow.Flow

class LocationDataRepository(private val locationDao: LocationDao) {

    val allLocations: Flow<List<LocationData>> = locationDao.getAllLocationData()

    @WorkerThread
    suspend fun inset(locationData: LocationData) {
        locationDao.add(locationData)
    }

}