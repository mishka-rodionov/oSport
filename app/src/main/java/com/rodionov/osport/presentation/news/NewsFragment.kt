package com.rodionov.osport.presentation.news

import com.rodionov.osport.R
import com.rodionov.base.ui.BaseFragment
import com.rodionov.osport.databinding.FragmentNewsBinding
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : com.rodionov.base.ui.BaseFragment(R.layout.fragment_news){

    private val binding: FragmentNewsBinding by viewBinding()

    override val toolbarTitle = R.string.toolbar_title_news

    private val viewModel : NewsViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    override fun initViews() {
        tvNews.setOnClickListener {
            viewModel.navigateToNewEvent()
        }
    }
}