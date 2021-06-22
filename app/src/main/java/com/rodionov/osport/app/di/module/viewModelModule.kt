package com.rodionov.osport.app.di.module

import com.rodionov.osport.presentation.eventcalendar.EventCalendarViewModel
import com.rodionov.osport.presentation.login.LoginViewModel
import com.rodionov.osport.presentation.map.MapViewModel
import com.rodionov.osport.presentation.newevent.NewEventViewModel
import com.rodionov.osport.presentation.news.NewsViewModel
import com.rodionov.osport.presentation.profile.ProfileViewModel
import com.rodionov.osport.presentation.registration.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
//    viewModel { AuthViewModel(get(), get(), get()) }
//    viewModel { (requestId: Int) -> DetailRequestViewModel(get(), requestId = requestId) }
    viewModel { EventCalendarViewModel() }
    viewModel { ProfileViewModel(get()) }
    viewModel { NewEventViewModel() }
    viewModel { MapViewModel() }
    viewModel { NewsViewModel() }
    viewModel { LoginViewModel(get()) }
    viewModel { RegistrationViewModel(get()) }
}