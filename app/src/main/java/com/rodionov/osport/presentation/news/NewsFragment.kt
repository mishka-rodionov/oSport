package com.rodionov.osport.presentation.news

import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment(R.layout.fragment_news){

    override val toolbarTitle = R.string.toolbar_title_news

    private val viewModel : NewsViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    override fun initViews() {
        tvNews.setOnClickListener {
            viewModel.navigateToNewEvent()
        }
    }
}