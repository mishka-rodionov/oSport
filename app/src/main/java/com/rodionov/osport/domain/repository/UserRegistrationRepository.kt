package com.rodionov.osport.domain.repository

import com.rodionov.osport.app.platform.State
import com.rodionov.osport.domain.model.User

interface UserRegistrationRepository {

    suspend fun userRegister(user: User, onSuccess:(String) -> Unit, onState: (State) -> Unit)

}