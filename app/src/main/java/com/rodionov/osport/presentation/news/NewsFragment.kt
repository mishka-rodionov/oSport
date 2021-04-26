package com.rodionov.osport.presentation.news

import androidx.viewbinding.ViewBinding
import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.databinding.FragmentNewsBinding
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment(){

    override val toolbarTitle = R.string.toolbar_title_news

    private val viewModel : NewsViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    override fun bindingInflater() = FragmentNewsBinding.inflate(layoutInflater)

    override fun initViews() {
        tvNews.setOnClickListener {
            viewModel.navigateToNewEvent()
        }
    }
}