package com.rodionov.osport.data.dto.requests

import com.google.gson.annotations.SerializedName

data class CompetitionShortRequest(
    @SerializedName("offset")
    val offset: Long,
    @SerializedName("limit")
    val limit: Int
)
