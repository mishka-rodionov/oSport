package com.rodionov.osport.data.repository

import android.content.Context
import androidx.core.content.edit
import com.rodionov.osport.domain.repository.PreferencesRepository

class PreferencesRepositoryImpl(context: Context): PreferencesRepository {

    private val sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    override fun setAuthorizationToken(authToken: String) {
        this.authToken = authToken
    }

    override fun getAuthorizationToken() = authToken

    private var authToken: String?
        get() = sharedPreferences.getString(AUTH_TOKEN, null)
        set(value) {
            sharedPreferences.edit {
                putString(AUTH_TOKEN, value)
            }
        }

    companion object {
        const val FILE_NAME = "OSportPreferences"
        const val AUTH_TOKEN = "AuthToken"
    }

}