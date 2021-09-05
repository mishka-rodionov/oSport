package com.rodionov.osport.app.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rodionov.osport.BuildConfig
import com.rodionov.osport.data.network.CompetitionApi
import com.rodionov.osport.data.network.UserRegistrationApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val TIMEOUT: Long = 30

val networkModule = module {

    single { buildRetrofit(get(), get()) }

    single { buildOkHttp() }

//    single { buildApiUser(get()) }

    single { buildUserRegistrationApi(get()) }

    single { buildCompetitionApi(get()) }

    single { buildJson() }

}


//private fun buildApiUser(retrofit: Retrofit): ApiUser? {
//    return retrofit.create(ApiUser::class.java)
//}

private fun buildUserRegistrationApi(retrofit: Retrofit): UserRegistrationApi? {
    return retrofit.create(UserRegistrationApi::class.java)
}

private fun buildCompetitionApi(retrofit: Retrofit): CompetitionApi? {
    return retrofit.create(CompetitionApi::class.java)
}

private fun buildJson() = GsonBuilder().create()


private fun buildOkHttp(/*headerInterceptor: HeaderInterceptor, validationInterceptor: ValidationInterceptor*/): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder()
    okHttpClientBuilder.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
    okHttpClientBuilder.readTimeout(TIMEOUT, TimeUnit.SECONDS)

//    if (BuildConfig.DEBUG) {
    //Ignore for sending newRequest (because duplicate query)
    val loggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    okHttpClientBuilder.addInterceptor(loggingInterceptor)
//       okHttpClientBuilder.addNetworkInterceptor(StethoInterceptor())
//    }

    return okHttpClientBuilder.build()
}

private fun buildRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_ENDPOINT)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

//private fun provideHeaderInterceptor(pref: Pref) = HeaderInterceptor(pref)
//
//private fun provideValidationInterceptor(gson: Gson) = ValidationInterceptor(gson)