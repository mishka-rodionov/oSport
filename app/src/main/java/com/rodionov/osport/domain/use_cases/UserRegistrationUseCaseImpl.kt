package com.rodionov.osport.domain.use_cases

import android.util.Log
import com.rodionov.osport.app.platform.State
import com.rodionov.osport.app.utils.LoggerTag.Companion.TAG
import com.rodionov.osport.app.utils.Result
import com.rodionov.osport.domain.model.User
import com.rodionov.osport.domain.repository.UserRegistrationRepository

class UserRegistrationUseCaseImpl(
    private val userRegistrationRepository: UserRegistrationRepository
): UserRegistrationUseCase {

    override suspend fun userRegister(user: User, onState: (State) -> Unit) {
        when(val answer = userRegistrationRepository.userRegister(user, onState)) {
            is Result.Success -> {
                Log.d(TAG, "userRegister: ${answer.data}")
            }
            is Result.Error -> {
                Log.d(TAG, "userRegister: ${answer.message}")
            }
        }

    }
}