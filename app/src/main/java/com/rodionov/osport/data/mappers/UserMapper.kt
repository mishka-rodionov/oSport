package com.rodionov.osport.data.mappers

import com.rodionov.osport.data.database.entities.UserEntity
import com.rodionov.osport.data.dto.response.UserResponse
import com.rodionov.osport.domain.model.User
import data.dto.requests.UserRequest

object UserMapper {

    fun toRequest(user: User, password: String) = user.run {
        UserRequest(
            firstName, middleName, lastName, phoneCountryPrefix, phoneNumber, email, password = password
        )
    }

    fun toModel(userResponse: UserResponse) = userResponse.run {
        User(
            id, firstName, middleName, lastName, phoneCountryPrefix, phoneNumber, email
        )
    }

    fun toModel(userEntity: UserEntity) = userEntity.run {
        User(
            id, firstName, middleName, lastName, phoneCountryPrefix, phoneNumber, email
        )
    }

    fun toEntity(user: User) = user.run {
        UserEntity(
            id, firstName, middleName, lastName, phoneCountryPrefix, phoneNumber, email
        )
    }

}