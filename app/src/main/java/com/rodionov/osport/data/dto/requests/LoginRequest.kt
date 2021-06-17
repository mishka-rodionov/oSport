package com.rodionov.osport.data.dto.requests

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("phone_prefix")
    val phonePrefix: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("password")
    val password: String
)
