package com.rodionov.osport.domain.use_cases

import android.util.Log
import com.rodionov.osport.app.platform.State
import com.rodionov.osport.app.utils.Logger.TAG
import com.rodionov.osport.app.utils.Result
import com.rodionov.osport.domain.model.User
import com.rodionov.osport.domain.repository.UserRegistrationRepository

class UserRegistrationUseCaseImpl(
    private val userRegistrationRepository: UserRegistrationRepository
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

    override suspend fun userLogin(phonePrefix: String, phone: String, password: String, onState: (State) -> Unit) {
        when(val result = userRegistrationRepository.userLogin(phonePrefix, phone, password, onState) ) {
            is Result.Success -> {
                Log.d(TAG, "userLogin: ${result.data}")
            }
            is Result.Error -> {
                Log.d(TAG, "userLogin: ${result.message}")
            }
        }
    }
}