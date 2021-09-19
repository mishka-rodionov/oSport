package com.rodionov.osport.presentation.event_center

import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.databinding.FragmentAccountBinding
import com.rodionov.osport.databinding.FragmentEventCenterBinding

class EventCenterFragment: BaseFragment(R.layout.fragment_event_center) {

    override fun initViews() {
        binding.tvtest.setOnClickListener {
            findNavController().navigate(R.id.action_eventCenterFragment_to_eventCreatorFragment)
        }
    }

    private val binding: FragmentEventCenterBinding by viewBinding()
}