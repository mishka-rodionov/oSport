package com.rodionov.osport.presentation.event_news

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.domain.model.CompetitionShort
import com.rodionov.osport.domain.repository.CompetitionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class EventNewsViewModel(
    private val competitionRepository: CompetitionRepository
): BaseViewModel() {

    var competitionShortState: StateFlow<PagingData<CompetitionShort>>? = null

    init {
        viewModelScope.launch(Dispatchers.IO) {
            competitionShortState = competitionRepository.getCompetitionShortListFlow().cachedIn(this).stateIn(this)
        }
    }

}