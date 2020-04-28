package com.rodionov.osport.presentation.registration

import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.app.platform.NavigationEvent
import com.rodionov.osport.presentation.account.AccountFragment

class RegistrationViewModel : BaseViewModel() {

    fun navigateToAccount() {
        navigate(NavigationEvent.PushFragment(AccountFragment()))
    }

}