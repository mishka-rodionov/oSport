package com.rodionov.osport.domain.use_cases

import com.rodionov.base.platform.State
import com.rodionov.osport.domain.model.User

interface UserRegistrationUseCase {

    suspend fun userRegister(user: User, password: String, onState: (State) -> Unit)
    suspend fun userLogin(phonePrefix: String, phone: String, password: String, onState: (State) -> Unit): Boolean
    fun checkAuthorization(onState: (State) -> Unit): Boolean
    suspend fun getUser(onState: (State) -> Unit): User

}