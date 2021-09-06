package com.rodionov.osport.data.remote_mediators

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.rodionov.osport.app.utils.Result
import com.rodionov.osport.data.database.dao.CompetitionDao
import com.rodionov.osport.data.database.dao.CompetitionShortRemoteKeyDao
import com.rodionov.osport.data.database.entities.CompetitionShortEntity
import com.rodionov.osport.data.database.entities.CompetitionShortRemoteKeyEntity
import com.rodionov.osport.data.mappers.toEntity
import com.rodionov.osport.domain.model.CompetitionShort
import com.rodionov.osport.domain.repository.CompetitionRepository
import retrofit2.HttpException
import java.io.IOException

@ExperimentalPagingApi
class CompetitionShortRemoteMediator(
    private val competitionRepository: CompetitionRepository,
    private val competitionShortRemoteKeyDao: CompetitionShortRemoteKeyDao,
    private val competitionDao: CompetitionDao
) : RemoteMediator<Int, CompetitionShortEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CompetitionShortEntity>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: DEFAULT_PAGE_INDEX
            }
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                // If remoteKeys is null, that means the refresh result is not in the database yet.
                // We can return Success with `endOfPaginationReached = false` because Paging
                // will call this method again if RemoteKeys becomes non-null.
                // If remoteKeys is NOT NULL but its prevKey is null, that means we've reached
                // the end of pagination for prepend.
                val prevKey = remoteKeys?.prevKey
                if (prevKey == null) {
                    return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                }
                prevKey
            }
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                // If remoteKeys is null, that means the refresh result is not in the database yet.
                // We can return Success with `endOfPaginationReached = false` because Paging
                // will call this method again if RemoteKeys becomes non-null.
                // If remoteKeys is NOT NULL but its prevKey is null, that means we've reached
                // the end of pagination for append.
                val nextKey = remoteKeys?.nextKey
                if (nextKey == null) {
                    return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                }
                nextKey
            }
        }

        try {

            when (val result = competitionRepository.getCompetitionShortList(
                state.config.pageSize * (page.toLong() - 1),
                state.config.pageSize
            )) {
                is Result.Success -> {
                    val endOfPaginationReached = result.data.isEmpty()
//                    repoDatabase.withTransaction {
                    // clear all tables in the database
                    if (loadType == LoadType.REFRESH) {
                        competitionShortRemoteKeyDao.clearAll()
                        competitionDao.clearAllCompetitionShort()
                    }
                    val prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1
                    val nextKey = if (endOfPaginationReached) null else page + 1
                    val keys = result.data.map { competitionShort ->
                        CompetitionShortRemoteKeyEntity(
                            id = competitionShort.id,
                            prevKey = prevKey,
                            nextKey = nextKey
                        )
                    }
                    competitionShortRemoteKeyDao.insertAll(keys)
                    competitionDao.insertAllCompetitionShort(result.data.map { it.toEntity() })
//                    }
                    return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
                }
                is Result.Error -> {
                    return MediatorResult.Error(result.error)
                }
            }

        } catch (exception: IOException) {
            return MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            return MediatorResult.Error(exception)
        }

    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, CompetitionShortEntity>): CompetitionShortRemoteKeyEntity? {
        // Get the last page that was retrieved, that contained items.
        // From that last page, get the last item
        return state.pages.lastOrNull() { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { competitionShort ->
                // Get the remote keys of the last item retrieved
                competitionShortRemoteKeyDao.getCompetitionShortRemoteKey(competitionShort.id)
            }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, CompetitionShortEntity>): CompetitionShortRemoteKeyEntity? {
        // Get the first page that was retrieved, that contained items.
        // From that first page, get the first item
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { competitionShort ->
                // Get the remote keys of the first items retrieved
                competitionShortRemoteKeyDao.getCompetitionShortRemoteKey(competitionShort.id)
            }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, CompetitionShortEntity>
    ): CompetitionShortRemoteKeyEntity? {
        // The paging library is trying to load data after the anchor position
        // Get the item closest to the anchor position
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { competitionShortId ->
                competitionShortRemoteKeyDao.getCompetitionShortRemoteKey(competitionShortId)
            }
        }
    }

    companion object {
        const val DEFAULT_PAGE_INDEX = 1
        const val DEFAULT_PAGE_SIZE = 5
    }

}