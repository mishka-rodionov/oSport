package com.rodionov.osport.presentation.login

import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.app.platform.NavigationEvent
import com.rodionov.osport.data.dto.requests.LoginRequest
import com.rodionov.osport.domain.repository.UserRegistrationRepository
import com.rodionov.osport.domain.use_cases.UserRegistrationUseCase
import com.rodionov.osport.presentation.profile.ProfileFragment
import com.rodionov.osport.presentation.account.AccountFragment
import com.rodionov.osport.presentation.registration.RegistrationFragment

class LoginViewModel(
    private val userRegistrationUseCase: UserRegistrationUseCase
) : BaseViewModel() {

    fun userLogin(phonePrefix: String, phone: String, password: String) {
        launch { userRegistrationUseCase.userLogin(phonePrefix = phonePrefix, phone = phone, password = password, onState = ::handleState) }
    }

    fun navigateToProfile() {
    }

    fun navigateToRegistration() {
    }

}