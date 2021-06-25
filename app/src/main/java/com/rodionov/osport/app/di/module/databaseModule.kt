package com.rodionov.osport.app.di.module

import android.content.Context
import com.rodionov.osport.data.database.OSportDatabase
import org.koin.dsl.module

val databaseModule = module {

    single { provideDatabase(get()) }
    single { getUserDao(get()) }
}

fun provideDatabase(context: Context) = OSportDatabase.createDatabase(context)

fun getUserDao(database: OSportDatabase) = database.userDao()

