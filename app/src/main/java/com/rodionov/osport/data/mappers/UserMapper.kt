package com.rodionov.osport.data.mappers

import com.rodionov.osport.domain.model.User
import data.dto.requests.UserRequest

object UserMapper {

    fun toRequest(user: User, password: String) = user.run {
        UserRequest(
            firstName, middleName, lastName, phoneCountryPrefix, phoneNumber, email, password = password
        )
    }

}