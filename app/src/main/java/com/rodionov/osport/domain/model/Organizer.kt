package com.rodionov.osport.domain.model

data class Organizer(
        val userId: String,
        val competitionId: String,
        val position: OrganizersPosition = OrganizersPosition.REFEREE
        )