package com.rodionov.osport.domain.model

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.HashMap

data class User(
    val id: String,
    val firstName: String? = null,
    val middleName: String? = null,
    val lastName: String? = null,
    val phoneCountryPrefix: String? = null,
    val phoneNumber: String? = null,
    val email: String? = null,
    val birthDate: Date? = null,
    val sportRanks: HashMap<Sport, String>? = null
)
