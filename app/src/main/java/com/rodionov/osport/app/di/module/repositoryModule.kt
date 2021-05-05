package com.rodionov.osport.app.di.module

import com.rodionov.osport.data.repository.UserRegistrationRepositoryImpl
import com.rodionov.osport.domain.repository.UserRegistrationRepository
import org.koin.dsl.module

val repositoryModule = module {

//    single<UserRepository> { UserRepositoryImp(get(), get(), get()) }
    single<UserRegistrationRepository> { UserRegistrationRepositoryImpl(get(), get()) }
}
