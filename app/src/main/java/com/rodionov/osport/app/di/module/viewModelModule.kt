package com.rodionov.osport.app.di.module

import com.rodionov.osport.presentation.eventcalendar.EventCalendarViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
//    viewModel { AuthViewModel(get(), get(), get()) }
//    viewModel { (requestId: Int) -> DetailRequestViewModel(get(), requestId = requestId) }
    viewModel { EventCalendarViewModel() }
}