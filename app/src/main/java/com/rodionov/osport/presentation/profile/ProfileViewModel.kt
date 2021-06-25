package com.rodionov.osport.presentation.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.app.platform.NavigationEvent
import com.rodionov.osport.app.utils.Logger
import com.rodionov.osport.domain.model.User
import com.rodionov.osport.domain.use_cases.UserRegistrationUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val userRegistrationUseCase: UserRegistrationUseCase
): BaseViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun checkAuthorization() = userRegistrationUseCase.checkAuthorization(::handleState)

    fun getUser() {
        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.d(Logger.TAG, "getUser: throwable = ${throwable.message}")
        }
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _user.postValue(userRegistrationUseCase.getUser(::handleState))
        }
    }

    fun navigateToLogin(action: Int) {
        navigate(NavigationEvent.PushFragment(action = action))
    }

    fun navigateToNewEvent(navigationEvent: NavigationEvent) {
        navigate(navigationEvent)
    }

}