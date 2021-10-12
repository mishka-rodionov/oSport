package com.rodionov.osport.domain.repository

import androidx.paging.PagingData
import com.rodionov.osport.data.database.entities.CompetitionShortEntity
import com.rodionov.osport.domain.model.CompetitionShort
import kotlinx.coroutines.flow.Flow
import com.rodionov.base.utils.Result

interface CompetitionRepository {

    suspend fun getCompetitionShortList(skip: Long, limit: Int) : Result<List<CompetitionShort>>
    fun getCompetitionShortListFlow(): Flow<PagingData<CompetitionShortEntity>>

}