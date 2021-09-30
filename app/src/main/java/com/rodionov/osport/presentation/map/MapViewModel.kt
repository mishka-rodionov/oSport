package com.rodionov.osport.presentation.map

import com.rodionov.base.viewmodel.BaseViewModel
import com.rodionov.base.platform.NavigationEvent

class MapViewModel : com.rodionov.base.viewmodel.BaseViewModel() {

    fun exit() {
        navigate(NavigationEvent.Exit)
    }

}