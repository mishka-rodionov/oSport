package com.rodionov.osport.presentation.newevent

import by.kirich1409.viewbindingdelegate.viewBinding
import com.rodionov.osport.R
import com.rodionov.base.ui.BaseFragment
import com.rodionov.osport.databinding.FragmentNewEventBinding
import kotlinx.android.synthetic.main.fragment_new_event.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewEventFragment : BaseFragment(R.layout.fragment_new_event) {

    private val binding: FragmentNewEventBinding by viewBinding()

    private val viewModel : NewEventViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    override fun initViews() {
        tvGoToMap.setOnClickListener {
            viewModel.navigateToMap()
        }
    }
}