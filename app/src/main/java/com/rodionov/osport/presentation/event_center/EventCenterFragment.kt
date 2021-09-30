package com.rodionov.osport.presentation.event_center

import com.rodionov.osport.R
import com.rodionov.base.ui.BaseFragment
import com.rodionov.osport.databinding.FragmentEventCenterBinding

class EventCenterFragment: com.rodionov.base.ui.BaseFragment(R.layout.fragment_event_center) {

    override fun initViews() {
        binding.tvtest.setOnClickListener {
            findNavController().navigate(R.id.action_eventCenterFragment_to_eventCreatorFragment)
        }
    }

    private val binding: FragmentEventCenterBinding by viewBinding()
}