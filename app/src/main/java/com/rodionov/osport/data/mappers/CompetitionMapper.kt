package com.rodionov.osport.data.mappers

import com.rodionov.osport.data.database.entities.CompetitionShortEntity
import com.rodionov.osport.data.dto.response.CompetitionShortResponse
import com.rodionov.osport.domain.model.CompetitionShort

fun CompetitionShortResponse.toModel(): CompetitionShort {
    return CompetitionShort(
        id, image, title, date, time, details
    )
}

fun CompetitionShort.toEntity() = CompetitionShortEntity(
    id, image, title, date, time, details
)

fun CompetitionShortEntity.toModel() = CompetitionShort(
    id, image, title, date, time, details
)
