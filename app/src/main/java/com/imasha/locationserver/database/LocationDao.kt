package com.imasha.locationserver.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.imasha.locationserver.models.LocationData

@Dao
interface LocationDao {
    @Query("SELECT * FROM location_data")
    fun getAllLocationData(): List<LocationData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(locationData: LocationData)

}