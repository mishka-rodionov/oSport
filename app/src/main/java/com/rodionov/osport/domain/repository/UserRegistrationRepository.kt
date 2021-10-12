package com.rodionov.osport.domain.repository

import com.rodionov.base.platform.State
import com.rodionov.osport.domain.model.User
import com.rodionov.base.utils.Result

interface UserRegistrationRepository {

    suspend fun userRegister(user: User, password: String, onState: (State) -> Unit): Result<String>
    suspend fun userLogin(phonePrefix: String, phone: String, password: String, onState: (State) -> Unit): Result<String>
    suspend fun getUserById(id: String, onState: (State) -> Unit): Result<User>
    suspend fun getUser(onState: (State) -> Unit): Result<User>

}