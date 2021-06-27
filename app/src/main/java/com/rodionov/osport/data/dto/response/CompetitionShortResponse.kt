package com.rodionov.osport.data.dto.response

import com.google.gson.annotations.SerializedName

data class CompetitionShortResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("details")
    val details: String
)