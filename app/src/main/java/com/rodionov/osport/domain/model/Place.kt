package com.rodionov.osport.domain.model

import com.google.gson.annotations.SerializedName
import com.rodionov.osport.domain.model.Coordinate

data class Place(
        @SerializedName("name")
        val name: String,
        @SerializedName("coordinates")
        val coordinates: Coordinate
)