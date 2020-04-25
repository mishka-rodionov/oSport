package com.rodionov.osport.presentation.news

import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.app.platform.NavigationEvent
import com.rodionov.osport.presentation.newevent.NewEventFragment

class NewsViewModel : BaseViewModel() {

    fun navigateToNewEvent() {
        navigate(NavigationEvent.PushFragment(NewEventFragment()))
    }

}