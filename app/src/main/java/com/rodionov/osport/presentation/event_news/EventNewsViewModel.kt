package com.rodionov.osport.presentation.event_news

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.data.mappers.toModel
import com.rodionov.osport.domain.repository.CompetitionRepository
import kotlinx.coroutines.flow.map

class EventNewsViewModel(
    private val competitionRepository: CompetitionRepository
) : BaseViewModel() {

    fun getFlow() = competitionRepository.getCompetitionShortListFlow().map {
        it.map { c ->
            c.toModel()
        }
    }.cachedIn(viewModelScope)

}