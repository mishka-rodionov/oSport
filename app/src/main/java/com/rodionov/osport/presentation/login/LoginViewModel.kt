package com.rodionov.osport.presentation.login

import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.app.platform.NavigationEvent
import com.rodionov.osport.presentation.profile.ProfileFragment
import com.rodionov.osport.presentation.account.AccountFragment
import com.rodionov.osport.presentation.registration.RegistrationFragment

class LoginViewModel : BaseViewModel() {

    fun navigateToProfile() {
        navigate(NavigationEvent.PushFragment(ProfileFragment()))
    }

    fun navigateToRegistration() {
        navigate(NavigationEvent.PushFragment(RegistrationFragment()))
    }

}