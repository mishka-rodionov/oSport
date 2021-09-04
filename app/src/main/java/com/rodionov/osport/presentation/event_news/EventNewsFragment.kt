package com.rodionov.osport.presentation.event_news

import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rodionov.osport.R
import com.rodionov.osport.app.extensions.launchWhenStarted
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.databinding.FragmentAccountBinding
import com.rodionov.osport.databinding.FragmentEventNewsBinding
import com.rodionov.osport.presentation.event_news.adapters.CompetitionShortPagingAdapter
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventNewsFragment: BaseFragment(R.layout.fragment_event_news) {

    private val binding: FragmentEventNewsBinding by viewBinding(FragmentEventNewsBinding::bind)

    private val viewModel: EventNewsViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    private val competitionShortAdapter by lazy { CompetitionShortPagingAdapter() }

    private var queryJob: Job? = null

    override fun initViews() {

        viewModel.competitionShortState?.onEach { competitionShort ->
            queryJob?.cancel()
            queryJob = lifecycleScope.launch { competitionShortAdapter.submitData(competitionShort) }
        }?.launchWhenStarted(lifecycleScope)

    }

}