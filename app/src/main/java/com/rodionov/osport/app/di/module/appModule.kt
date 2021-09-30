package com.rodionov.osport.app.di.module

import android.content.Context
import com.google.gson.Gson
import com.rodionov.base.platform.ErrorHandler
import com.rodionov.base.platform.LocationProvider
import com.rodionov.base.platform.NetworkHandler
import com.rodionov.base.platform.ResourceManager
import org.koin.dsl.module

val appModule = module {

    single { provideNetworkHandler(get()) }

    single { provideErrorHandler(get()) }

    single { provideResourceManager(get()) }

    factory { provideLocationProvider(get()) }
}

fun provideNetworkHandler(context: Context): NetworkHandler {
    return NetworkHandler(context)
}

fun provideErrorHandler(networkHandler: NetworkHandler): ErrorHandler {
    return ErrorHandler(networkHandler, Gson())
}

fun provideResourceManager(context: Context): ResourceManager {
    return ResourceManager(context)
}

fun provideLocationProvider(context: Context): LocationProvider {
    return LocationProvider(context)
}