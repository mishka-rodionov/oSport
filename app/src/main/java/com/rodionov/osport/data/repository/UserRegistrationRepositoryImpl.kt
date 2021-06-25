package com.rodionov.osport.data.repository

import com.rodionov.osport.app.platform.BaseRepository
import com.rodionov.osport.app.platform.ErrorHandler
import com.rodionov.osport.app.platform.State
import com.rodionov.osport.data.mappers.CommonMapper
import com.rodionov.osport.data.mappers.UserMapper
import com.rodionov.osport.data.network.UserRegistrationApi
import com.rodionov.osport.domain.model.User
import com.rodionov.osport.domain.repository.UserRegistrationRepository
import com.rodionov.osport.app.utils.Result
import com.rodionov.osport.data.database.dao.UserDao
import com.rodionov.osport.data.dto.IdDto
import com.rodionov.osport.data.dto.requests.LoginRequest

class UserRegistrationRepositoryImpl(
    errorHandler: ErrorHandler,
    private val userRegistrationApi: UserRegistrationApi,
    private val userDao: UserDao
) : BaseRepository(errorHandler), UserRegistrationRepository {

    override suspend fun userRegister(
        user: User,
        password: String,
        onState: (State) -> Unit
    ): Result<String> {
        return resultExecute(
            onState = onState
        ) {
            CommonMapper.toId(
                userRegistrationApi.userRegister(
                    UserMapper.toRequest(
                        user,
                        password
                    )
                )
            )
        }
    }

    override suspend fun userLogin(
        phonePrefix: String,
        phone: String,
        password: String,
        onState: (State) -> Unit
    ): Result<String> {
        return resultExecute(onState = onState) {
            val loginResponse =
                userRegistrationApi.userLogin(LoginRequest(phonePrefix, phone, password))
            getUserById(id = loginResponse.userId, onState = onState)
            loginResponse.authToken
        }
    }

    override suspend fun getUserById(id: String, onState: (State) -> Unit): Result<User> {
        return resultExecute(onState = onState) {
            val user = UserMapper.toModel(userRegistrationApi.getUserById(IdDto(id = id)))
            userDao.setUser(UserMapper.toEntity(user = user))
            user
        }
    }

    override suspend fun getUser(onState: (State) -> Unit): Result<User> {
        return resultExecute(onState = onState) {
            UserMapper.toModel(userDao.getUser())
        }
    }
}