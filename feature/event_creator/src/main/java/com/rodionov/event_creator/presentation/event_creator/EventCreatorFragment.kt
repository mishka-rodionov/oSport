package com.rodionov.event_creator.presentation.event_creator

import by.kirich1409.viewbindingdelegate.viewBinding
import com.rodionov.base.ui.BaseFragment
import com.rodionov.event_creator.R
import com.rodionov.event_creator.databinding.FragmentEventCreatorBinding

class EventCreatorFragment: BaseFragment(R.layout.fragment_event_creator) {

    private val binding: FragmentEventCreatorBinding by viewBinding(FragmentEventCreatorBinding::bind)

    override fun initViews() {

    }
}