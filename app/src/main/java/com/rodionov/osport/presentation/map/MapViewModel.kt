package com.rodionov.osport.presentation.map

import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.app.platform.NavigationEvent

class MapViewModel : BaseViewModel() {

    fun exit() {
        navigate(NavigationEvent.Exit)
    }

}