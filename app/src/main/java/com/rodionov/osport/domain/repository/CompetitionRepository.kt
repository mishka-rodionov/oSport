package com.rodionov.osport.domain.repository

import com.rodionov.osport.app.utils.Result
import com.rodionov.osport.domain.model.CompetitionShort

interface CompetitionRepository {

    suspend fun getCompetitionShortList(skip: Long, limit: Int) : Result<List<CompetitionShort>>

}