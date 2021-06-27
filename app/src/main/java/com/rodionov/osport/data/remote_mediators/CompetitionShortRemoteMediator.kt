package com.rodionov.osport.data.remote_mediators

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.rodionov.osport.domain.model.CompetitionShort

@ExperimentalPagingApi
class CompetitionShortRemoteMediator: RemoteMediator<Int, CompetitionShort>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CompetitionShort>
    ): MediatorResult {

    }
}