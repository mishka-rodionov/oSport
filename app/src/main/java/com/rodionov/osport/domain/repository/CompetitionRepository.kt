package com.rodionov.osport.domain.repository

import androidx.paging.PagingData
import com.rodionov.osport.app.utils.Result
import com.rodionov.osport.domain.model.CompetitionShort
import kotlinx.coroutines.flow.Flow

interface CompetitionRepository {

    suspend fun getCompetitionShortList(skip: Long, limit: Int) : Result<List<CompetitionShort>>
    suspend fun getCompetitionShortListFlow(): Flow<PagingData<CompetitionShort>>

}