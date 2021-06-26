package com.rodionov.osport.data.dto.requests

import com.google.gson.annotations.SerializedName
import com.rodionov.osport.data.dto.OrganizerDto
import com.rodionov.osport.domain.model.CompetitionState
import com.rodionov.osport.domain.model.Place

data class CompetitionRequest(
    @SerializedName("date")
    val date: String,
    @SerializedName("state")
    val state: CompetitionState? = null,
    @SerializedName("main_image")
    val mainImage: String? = null,
    @SerializedName("sport_type")
    val sportType: String,
    @SerializedName("place")
    val place: Place,
    @SerializedName("start_interval")
    val startInterval: Float,
    @SerializedName("organizers")
    val organizers: List<OrganizerDto>,
    @SerializedName("title")
    val title: String,
//    @SerializedName("participants_groups")
//    val participantGroups: List<String>,
    @SerializedName("description")
    val description: String? = null
)