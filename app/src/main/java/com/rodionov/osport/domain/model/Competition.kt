package com.rodionov.osport.domain.model

import java.util.*

data class Competition(
    var id: String,
    val date: Date,
    val state: CompetitionState,
    val mainImage: String? = null,
    val sportType: String,
    val place: Place,
    val organizers: List<Organizer>,
    val title: String,
    val startInterval: Double,
    val description: String? = null
)