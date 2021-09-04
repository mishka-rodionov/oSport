package com.rodionov.osport.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rodionov.osport.app.platform.BaseRepository
import com.rodionov.osport.app.platform.ErrorHandler
import com.rodionov.osport.app.utils.Result
import com.rodionov.osport.data.database.dao.CompetitionDao
import com.rodionov.osport.data.database.dao.CompetitionShortRemoteKeyDao
import com.rodionov.osport.data.dto.requests.CompetitionRequest
import com.rodionov.osport.data.dto.requests.CompetitionShortRequest
import com.rodionov.osport.data.dto.response.CompetitionShortResponse
import com.rodionov.osport.data.mappers.toModel
import com.rodionov.osport.data.network.CompetitionApi
import com.rodionov.osport.data.remote_mediators.CompetitionShortRemoteMediator
import com.rodionov.osport.domain.model.CompetitionShort
import com.rodionov.osport.domain.repository.CompetitionRepository
import kotlinx.coroutines.flow.Flow

class CompetitionRepositoryImpl(
    private val competitionApi: CompetitionApi,
    private val competitionShortRemoteKeyDao: CompetitionShortRemoteKeyDao,
    private val competitionDao: CompetitionDao,
    errorHandler: ErrorHandler
) : BaseRepository(errorHandler), CompetitionRepository {

    override suspend fun getCompetitionShortList(
        skip: Long,
        limit: Int
    ): Result<List<CompetitionShort>> {
        return resultExecute(onState = {}) {
            competitionApi.getCompetitionsShort(
                CompetitionShortRequest(
                    offset = skip,
                    limit = limit
                )
            ).map {
                it.toModel()
            }
        }
    }

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun getCompetitionShortListFlow(): Flow<PagingData<CompetitionShort>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = CompetitionShortRemoteMediator(
                competitionRepository = this,
                competitionShortRemoteKeyDao = competitionShortRemoteKeyDao,
                competitionDao = competitionDao
            ),
            pagingSourceFactory = { competitionDao.getCompetitionShortPagingSource() }
        ).flow
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}