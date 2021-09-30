package com.rodionov.base.viewmodel

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodionov.base.platform.Event
import com.rodionov.base.platform.NavigationEvent
import com.rodionov.base.platform.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    val mainState = MutableLiveData<Event<State>>()
    val message = MutableLiveData<Event<String>>()
    val fragmentNavigation = MutableLiveData<Event<NavigationEvent>>()

    protected fun handleState(state: State) {
        mainState.value = Event(state)
    }

    protected fun handleError(state: State) {
        if (state is State.Error) {
            mainState.value = Event(state)
        }
    }

    protected fun handleStateWithExit(state: State) {
        mainState.value = Event(state)
        if (state is State.Error) {
            Handler().postDelayed({navigate(NavigationEvent.Exit)}, 400)
        }
    }

    protected fun launch(func: suspend () -> Unit) =
        viewModelScope.launch(Dispatchers.Main) { func.invoke() }

    protected fun launchIO(func: suspend () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) { func.invoke() }

    fun navigate(navigationEvent: NavigationEvent) {
        fragmentNavigation.value = Event(navigationEvent)
    }
}