package com.rodionov.osport.presentation.newevent

import com.rodionov.osport.R
import com.rodionov.base.ui.BaseFragment
import com.rodionov.osport.databinding.FragmentNewEventBinding
import kotlinx.android.synthetic.main.fragment_new_event.*

class NewEventFragment : com.rodionov.base.ui.BaseFragment(R.layout.fragment_new_event) {

    private val binding: FragmentNewEventBinding by viewBinding()

    private val viewModel : NewEventViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    override fun initViews() {
        tvGoToMap.setOnClickListener {
            viewModel.navigateToMap()
        }
    }
}