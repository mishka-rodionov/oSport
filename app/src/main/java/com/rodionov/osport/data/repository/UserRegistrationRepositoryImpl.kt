package com.rodionov.osport.data.repository

import com.rodionov.osport.app.platform.BaseRepository
import com.rodionov.osport.app.platform.ErrorHandler
import com.rodionov.osport.app.platform.State
import com.rodionov.osport.data.mappers.CommonMapper
import com.rodionov.osport.data.mappers.UserMapper
import com.rodionov.osport.data.network.UserRegistrationApi
import com.rodionov.osport.domain.model.User
import com.rodionov.osport.domain.repository.UserRegistrationRepository

class UserRegistrationRepositoryImpl(
    errorHandler: ErrorHandler,
    private val userRegistrationApi: UserRegistrationApi
) : BaseRepository(errorHandler), UserRegistrationRepository {

    override suspend fun userRegister(user: User, onSuccess:(String) -> Unit, onState: (State) -> Unit) {
        execute(
            onSuccess = onSuccess,
            onState = onState
        ) {
            CommonMapper.toId(userRegistrationApi.userRegister(UserMapper.toRequest(user)))
        }
    }
}