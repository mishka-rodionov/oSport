package com.rodionov.osport.domain.model

data class FinishListItem(
        val id: String,
        val userId: String,
        val competitionId: String,
        val startTime: Long,
        val finishTime: Long,
        val resultTime: Long,
        val splits: List<Long>,
        val absolutePlace: Int,
        val placeInCategory: Int,
        val participantGroup: ParticipantGroup,
        val description: String
)