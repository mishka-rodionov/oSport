package com.rodionov.osport.presentation.registration

import com.rodionov.base.viewmodel.BaseViewModel
import com.rodionov.osport.domain.model.User
import com.rodionov.osport.domain.use_cases.UserRegistrationUseCase

class RegistrationViewModel(
    private val userRegistrationUseCase: UserRegistrationUseCase
) : com.rodionov.base.viewmodel.BaseViewModel() {

    fun register(user: User, password: String) {
        launch{
            userRegistrationUseCase.userRegister(user, password, ::handleState)
        }
    }

    fun checkPassword(password: String, repeatPassword: String) = password == repeatPassword

    fun navigateToAccount() {
    }

}