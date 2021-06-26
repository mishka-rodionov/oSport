package com.rodionov.osport.data.dto

import com.google.gson.annotations.SerializedName

data class OrganizerDto(
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("organizer_position")
    val organizerPosition: String
)