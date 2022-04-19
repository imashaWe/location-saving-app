package com.imasha.locationserver.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.imasha.locationserver.models.LocationData

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [LocationData::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun locationDao(): LocationDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "location-database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}