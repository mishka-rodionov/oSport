package com.rodionov.osport.presentation.eventdetails

import androidx.viewbinding.ViewBinding
import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.databinding.FragmentEventDetailsBinding

class EventDetailsFragment : BaseFragment() {

    override val toolbarTitle = R.string.toolbar_title_event_details

    override fun initViews() {
    }

    override fun bindingInflater() = FragmentEventDetailsBinding.inflate(layoutInflater)
}