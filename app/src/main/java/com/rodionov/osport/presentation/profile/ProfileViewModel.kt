package com.rodionov.osport.presentation.profile

import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.app.platform.NavigationEvent
import com.rodionov.osport.domain.use_cases.UserRegistrationUseCase
import com.rodionov.osport.presentation.login.LoginFragment
import com.rodionov.osport.presentation.newevent.NewEventFragment

class ProfileViewModel(
    private val userRegistrationUseCase: UserRegistrationUseCase
): BaseViewModel() {

    fun checkAuthorization() = userRegistrationUseCase.checkAuthorization(::handleState)

    fun navigateToLogin(action: Int) {
        navigate(NavigationEvent.PushFragment(action = action))
    }

    fun navigateToNewEvent(navigationEvent: NavigationEvent) {
        navigate(navigationEvent)
    }

}