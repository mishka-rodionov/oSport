package com.rodionov.osport.data.network

import com.rodionov.osport.data.dto.IdDto
import com.rodionov.osport.data.dto.requests.LoginRequest
import com.rodionov.osport.data.dto.response.LoginResponse
import com.rodionov.osport.data.dto.response.UserResponse
import data.dto.requests.UserRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface UserRegistrationApi {

    @POST(USER_REGISTER)
    suspend fun userRegister(@Body userRequest: UserRequest): IdDto

    @POST(USER_LOGIN)
    suspend fun userLogin(@Body loginRequest: LoginRequest): LoginResponse

    @POST(USER_GET_BY_ID)
    suspend fun getUserById(@Body idDto: IdDto): UserResponse

    companion object {
        const val USER_REGISTER = "/user/new"
        const val USER_LOGIN = "/user/login"
        const val USER_GET_BY_ID = "/user/get_by_id"
    }

}