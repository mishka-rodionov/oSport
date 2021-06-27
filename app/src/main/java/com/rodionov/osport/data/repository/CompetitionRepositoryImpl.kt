package com.rodionov.osport.data.repository

import com.rodionov.osport.app.platform.BaseRepository
import com.rodionov.osport.app.platform.ErrorHandler
import com.rodionov.osport.app.utils.Result
import com.rodionov.osport.data.network.CompetitionApi
import com.rodionov.osport.domain.model.CompetitionShort
import com.rodionov.osport.domain.repository.CompetitionRepository

class CompetitionRepositoryImpl(
    private val competitionApi: CompetitionApi,
    errorHandler: ErrorHandler
) : BaseRepository(errorHandler), CompetitionRepository {

    override suspend fun getCompetitionShortList(
        skip: Long,
        limit: Int
    ): Result<List<CompetitionShort>> {

    }
}