package com.rodionov.osport.presentation.eventdetails

import com.rodionov.osport.R
import com.rodionov.base.ui.BaseFragment
import com.rodionov.osport.databinding.FragmentEventDetailsBinding

class EventDetailsFragment : com.rodionov.base.ui.BaseFragment(R.layout.fragment_event_details) {

    private val binding: FragmentEventDetailsBinding by viewBinding()

    override val toolbarTitle = R.string.toolbar_title_event_details

    override fun initViews() {
    }

}