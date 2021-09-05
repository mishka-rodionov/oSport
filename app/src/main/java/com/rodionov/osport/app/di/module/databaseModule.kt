package com.rodionov.osport.app.di.module

import android.content.Context
import com.rodionov.osport.data.database.OSportDatabase
import org.koin.dsl.module

val databaseModule = module {

    single { provideDatabase(get()) }
    single { getUserDao(get()) }
    single { getCompetitionDao(get()) }
    single { getCompetitionShortRemoteKeyDao(get()) }
}

fun provideDatabase(context: Context) = OSportDatabase.createDatabase(context)

fun getUserDao(database: OSportDatabase) = database.userDao()

fun getCompetitionDao(database: OSportDatabase) = database.competitionDao()

fun getCompetitionShortRemoteKeyDao(database: OSportDatabase) = database.competitionShortRemoteKeyDao()

