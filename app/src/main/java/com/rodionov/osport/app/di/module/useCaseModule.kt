package com.rodionov.osport.app.di.module

import com.rodionov.osport.domain.use_cases.UserRegistrationUseCase
import com.rodionov.osport.domain.use_cases.UserRegistrationUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<UserRegistrationUseCase> { UserRegistrationUseCaseImpl(get()) }
}