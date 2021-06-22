package com.rodionov.osport.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.app.platform.NavigationEvent
import com.rodionov.osport.data.dto.requests.LoginRequest
import com.rodionov.osport.domain.repository.UserRegistrationRepository
import com.rodionov.osport.domain.use_cases.UserRegistrationUseCase
import com.rodionov.osport.presentation.profile.ProfileFragment
import com.rodionov.osport.presentation.account.AccountFragment
import com.rodionov.osport.presentation.registration.RegistrationFragment
import kotlinx.coroutines.flow.*

class LoginViewModel(
    private val userRegistrationUseCase: UserRegistrationUseCase
) : BaseViewModel() {

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