package com.rodionov.osport.data.mappers

import com.rodionov.osport.data.dto.response.CompetitionShortResponse
import com.rodionov.osport.domain.model.CompetitionShort

fun CompetitionShortResponse.toModel(): CompetitionShort {
    return CompetitionShort(
        id, image, title, date, time, details
    )
}
