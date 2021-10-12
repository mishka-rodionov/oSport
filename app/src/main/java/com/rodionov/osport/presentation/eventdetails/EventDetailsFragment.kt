package com.rodionov.osport.presentation.eventdetails

import by.kirich1409.viewbindingdelegate.viewBinding
import com.rodionov.osport.R
import com.rodionov.base.ui.BaseFragment
import com.rodionov.osport.databinding.FragmentEventDetailsBinding

class EventDetailsFragment : BaseFragment(R.layout.fragment_event_details) {

    private val binding: FragmentEventDetailsBinding by viewBinding()

    override val toolbarTitle = R.string.toolbar_title_event_details

    override fun initViews() {
    }

}