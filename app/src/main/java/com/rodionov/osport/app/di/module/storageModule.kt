package com.rodionov.osport.app.di.module

import android.content.Context
import com.rodionov.osport.data.storage.Pref
import org.koin.dsl.module

val storageModule = module {

    single { provideSharedPreferences(get()) }
}

fun provideSharedPreferences(context: Context): Pref {
    return Pref(context)
}