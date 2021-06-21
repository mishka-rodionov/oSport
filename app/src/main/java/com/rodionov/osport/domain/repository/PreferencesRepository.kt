package com.rodionov.osport.domain.repository

interface PreferencesRepository {

    fun setAuthorizationToken(authToken: String)
    fun getAuthorizationToken(): String?

}