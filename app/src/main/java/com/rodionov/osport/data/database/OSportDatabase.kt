package com.rodionov.osport.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rodionov.osport.data.database.OSportDatabase.Companion.DATABASE_VERSION
import com.rodionov.osport.data.database.dao.CompetitionDao
import com.rodionov.osport.data.database.dao.CompetitionShortRemoteKeyDao
import com.rodionov.osport.data.database.dao.UserDao
import com.rodionov.osport.data.database.entities.CompetitionShortEntity
import com.rodionov.osport.data.database.entities.CompetitionShortRemoteKeyEntity
import com.rodionov.osport.data.database.entities.UserEntity

@Database(
    entities = [UserEntity::class, CompetitionShortEntity::class, CompetitionShortRemoteKeyEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class OSportDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun competitionDao(): CompetitionDao
    abstract fun competitionShortRemoteKeyDao(): CompetitionShortRemoteKeyDao

    companion object {
        const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "OSportDatabase"
        fun createDatabase(context: Context): OSportDatabase =
            Room.databaseBuilder(context, OSportDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration().build()

    }

}