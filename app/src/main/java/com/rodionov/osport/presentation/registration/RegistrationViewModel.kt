package com.rodionov.osport.presentation.registration

import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.app.platform.NavigationEvent
import com.rodionov.osport.domain.model.User
import com.rodionov.osport.domain.use_cases.UserRegistrationUseCase
import com.rodionov.osport.presentation.account.AccountFragment

class RegistrationViewModel(
    private val userRegistrationUseCase: UserRegistrationUseCase
) : BaseViewModel() {

    fun register(user: User) {
        launch{
            userRegistrationUseCase.userRegister(user, ::handleState)
        }
    }

    fun navigateToAccount() {
    }

}