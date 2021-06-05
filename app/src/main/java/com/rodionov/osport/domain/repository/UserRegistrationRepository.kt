package com.rodionov.osport.domain.repository

import com.rodionov.osport.app.platform.State
import com.rodionov.osport.app.utils.Result
import com.rodionov.osport.domain.model.User

interface UserRegistrationRepository {

    suspend fun userRegister(user: User, onState: (State) -> Unit): Result<String>
    suspend fun userLogin(phone: String, password: String, onState: (State) -> Unit): Result<String>

}