package com.rodionov.osport.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rodionov.osport.data.database.OSportDatabase.Companion.DATABASE_VERSION
import com.rodionov.osport.data.database.entities.UserEntity

@Database(
    entities = [UserEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class OSportDatabase: RoomDatabase() {

    companion object {
        const val DATABASE_VERSION = 1
    }

}