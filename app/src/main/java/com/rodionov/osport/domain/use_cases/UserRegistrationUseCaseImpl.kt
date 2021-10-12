package com.rodionov.osport.domain.use_cases

import android.util.Log
import com.rodionov.base.platform.State
import com.rodionov.base.utils.Logger.TAG
import com.rodionov.osport.domain.model.User
import com.rodionov.osport.domain.repository.PreferencesRepository
import com.rodionov.osport.domain.repository.UserRegistrationRepository
import com.rodionov.base.utils.Result

class UserRegistrationUseCaseImpl(
    private val userRegistrationRepository: UserRegistrationRepository,
    private val preferencesRepository: PreferencesRepository
) : UserRegistrationUseCase {

    override suspend fun userRegister(user: User, password: String, onState: (State) -> Unit) {
        when (val answer = userRegistrationRepository.userRegister(user, password, onState)) {
            is Result.Success -> {
                Log.d(TAG, "userRegister: ${answer.data}")
                userLogin(
                    user.phoneCountryPrefix ?: return,
                    user.phoneNumber ?: return,
                    password,
                    onState
                )
            }
            is Result.Error -> {
                Log.d(TAG, "userRegister: ${answer.message}")
            }
        }
    }

    override suspend fun userLogin(phonePrefix: String, phone: String, password: String, onState: (State) -> Unit): Boolean {
        return when(val result = userRegistrationRepository.userLogin(phonePrefix, phone, password, onState) ) {
            is Result.Success -> {
                Log.d(TAG, "userLogin: ${result.data}")
                preferencesRepository.setAuthorizationToken(result.data)
                Log.d(TAG, "userLogin: preferencesRepository.getAuthorizationToken = " +
                        "${preferencesRepository.getAuthorizationToken()}")
                true
            }
            is Result.Error -> {
                Log.d(TAG, "userLogin: ${result.message}")
                false
            }
        }
    }

    override fun checkAuthorization(onState: (State) -> Unit): Boolean = !preferencesRepository.getAuthorizationToken().isNullOrEmpty()

    override suspend fun getUser(onState: (State) -> Unit): User {
        return when(val result = userRegistrationRepository.getUser(onState)) {
            is Result.Success -> {
                result.data
            }
            is Result.Error -> {
                throw Throwable(message = "User not found")
            }
        }
    }
}