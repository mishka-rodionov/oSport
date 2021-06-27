package com.rodionov.osport.data.paging_sources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rodionov.osport.data.dto.response.CompetitionShortResponse

class CompetitionShortPagingSource: PagingSource<Int, CompetitionShortResponse>() {

    override fun getRefreshKey(state: PagingState<Int, CompetitionShortResponse>): Int? {

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CompetitionShortResponse> {

    }
}