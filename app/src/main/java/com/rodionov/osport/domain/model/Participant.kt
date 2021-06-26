package com.rodionov.osport.domain.model

import java.util.*

data class Participant(
    val userId: String,
    val competitionId: String,
    val registrationDate: Date,
    val gender: Gender,
    val group: ParticipantGroup,
    val isPaid: Boolean? = null
)