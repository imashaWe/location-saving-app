package com.imasha.locationserver.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_data")
data class LocationData(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val name: String?,
    val latitude: Long?,
    val longitude: Long?
)
