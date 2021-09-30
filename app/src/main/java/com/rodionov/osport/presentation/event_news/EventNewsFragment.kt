package com.rodionov.osport.presentation.event_news

import android.util.Log
import com.rodionov.osport.R
import com.rodionov.base.ui.BaseFragment
import com.rodionov.osport.databinding.FragmentEventNewsBinding
import com.rodionov.osport.presentation.event_news.adapters.CompetitionShortPagingAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged

class EventNewsFragment : com.rodionov.base.ui.BaseFragment(R.layout.fragment_event_news) {

    private val binding: FragmentEventNewsBinding by viewBinding(FragmentEventNewsBinding::bind)

    private val viewModel: EventNewsViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    private val competitionShortAdapter by lazy { CompetitionShortPagingAdapter() }

    override fun initViews() {

        binding.rvEvent.adapter = competitionShortAdapter

        lifecycleScope.launchWhenResumed {
            viewModel.getFlow().distinctUntilChanged().collectLatest {
                Log.d("LOG_TAG", "initViews: competition short = $it")
                competitionShortAdapter.submitData(it)
            }
        }

    }

}