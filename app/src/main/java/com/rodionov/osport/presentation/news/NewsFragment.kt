package com.rodionov.osport.presentation.news

import by.kirich1409.viewbindingdelegate.viewBinding
import com.rodionov.osport.R
import com.rodionov.base.ui.BaseFragment
import com.rodionov.osport.databinding.FragmentNewsBinding
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment(R.layout.fragment_news){

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