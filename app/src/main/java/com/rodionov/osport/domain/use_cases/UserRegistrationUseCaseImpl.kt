package com.rodionov.osport.domain.use_cases

import com.rodionov.osport.domain.model.User
import com.rodionov.osport.domain.repository.UserRegistrationRepository

class UserRegistrationUseCaseImpl(
    private val userRegistrationRepository: UserRegistrationRepository
): UserRegistrationUseCase {

    override suspend fun userRegister(user: User) {
        userRegistrationRepository.userRegister()
    }
}