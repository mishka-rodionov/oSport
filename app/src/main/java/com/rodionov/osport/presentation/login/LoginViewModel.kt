package com.rodionov.osport.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rodionov.base.viewmodel.BaseViewModel
import com.rodionov.base.platform.NavigationEvent
import com.rodionov.osport.domain.use_cases.UserRegistrationUseCase

class LoginViewModel(
    private val userRegistrationUseCase: UserRegistrationUseCase
) : com.rodionov.base.viewmodel.BaseViewModel() {

    private val _successfulLogin = MutableLiveData<Boolean>()
    val successfulLogin: LiveData<Boolean> =_successfulLogin

    fun userLogin(phonePrefix: String, phone: String, password: String) {
        launch {
            _successfulLogin.value = userRegistrationUseCase.userLogin(
                phonePrefix = phonePrefix,
                phone = phone,
                password = password,
                onState = ::handleState
            )
        }
    }

    fun navigateToProfile(action: Int) {
        navigate(NavigationEvent.PushFragment(action = action))
    }

    fun navigateToRegistration() {
    }

}