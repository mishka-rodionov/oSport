package com.rodionov.osport.data.dto.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
        @SerializedName("id")
        val id: String,
        @SerializedName("first_name")
        val firstName: String? = null,
        @SerializedName("middle_name")
        val middleName: String? = null,
        @SerializedName("last_name")
        val lastName: String? = null,
        @SerializedName("phone_country_prefix")
        val phoneCountryPrefix: String? = null,
        @SerializedName("phone_number")
        val phoneNumber: String? = null,
        @SerializedName("email")
        val email: String? = null,
        @SerializedName("birth_date")
        val birthDate: String? = null,
        @SerializedName("sport_ranks")
        val sportRanks: HashMap<String, String>? = null
)