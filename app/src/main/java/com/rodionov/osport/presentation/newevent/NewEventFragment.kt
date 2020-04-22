package com.rodionov.osport.presentation.newevent

import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_new_event.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewEventFragment : BaseFragment(R.layout.fragment_new_event) {

    private val viewModel : NewEventViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    override fun initViews() {
        tvGoToMap.setOnClickListener {
            viewModel.navigateToMap()
        }
    }
}