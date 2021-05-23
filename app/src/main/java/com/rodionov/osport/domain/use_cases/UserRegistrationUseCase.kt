package com.rodionov.osport.domain.use_cases

import com.rodionov.osport.app.platform.State
import com.rodionov.osport.domain.model.User

interface UserRegistrationUseCase {

    suspend fun userRegister(user: User, onState: (State) -> Unit)

}