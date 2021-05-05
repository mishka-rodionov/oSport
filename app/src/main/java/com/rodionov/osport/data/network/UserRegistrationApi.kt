package com.rodionov.osport.data.network

import com.rodionov.osport.data.dto.IdDto
import data.dto.requests.UserRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface UserRegistrationApi {

    @POST(USER_REGISTER)
    suspend fun userRegister(@Body userRequest: UserRequest): IdDto

    companion object {
        const val USER_REGISTER = "/user/new"
    }

}