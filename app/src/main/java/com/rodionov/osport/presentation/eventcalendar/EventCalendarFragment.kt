package com.rodionov.osport.presentation.eventcalendar

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.rodionov.osport.R
import com.rodionov.base.extensions.setData
import com.rodionov.base.ui.BaseFragment
import com.rodionov.osport.databinding.FragmentEventCalendarBinding
import com.rodionov.osport.presentation.eventcalendar.delegates.EventCalendarItem
import com.rodionov.osport.presentation.eventcalendar.delegates.eventCalendarDelegates
import kotlinx.android.synthetic.main.fragment_event_calendar.*

/**
 * Created by rodionov on 30.03.2020.
 */
class EventCalendarFragment : com.rodionov.base.ui.BaseFragment(R.layout.fragment_event_calendar) {

    private val binding: FragmentEventCalendarBinding by viewBinding()

    override val toolbarTitle = R.string.toolbar_title_calendar

    private val viewModel : EventCalendarViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    private val eventCalendarAdapter by lazy {
        ListDelegationAdapter(
            eventCalendarDelegates(::handleEventItemClick)
        )
    }

    private fun handleEventItemClick() {
        viewModel.navigateToEvent()
    }

    override fun initViews() {
        rvEventCalendar.adapter = eventCalendarAdapter
        val list = listOf(
            EventCalendarItem(date = "Today",time = "11 : 00",place = "Saratov",orgs = "FSO Saratov"),
            EventCalendarItem(date = "09.05.2020",time = "09 : 00",place = "Balashov", orgs = "FSO Balashov"),
            EventCalendarItem(date = "Today",time = "11 : 00",place = "Saratov",orgs = "FSO Saratov"),
            EventCalendarItem(date = "09.05.2020",time = "09 : 00",place = "Balashov", orgs = "FSO Balashov"),
            EventCalendarItem(date = "Today",time = "11 : 00",place = "Saratov",orgs = "FSO Saratov"),
            EventCalendarItem(date = "09.05.2020",time = "09 : 00",place = "Balashov", orgs = "FSO Balashov"),
            EventCalendarItem(date = "Today",time = "11 : 00",place = "Saratov",orgs = "FSO Saratov"),
            EventCalendarItem(date = "09.05.2020",time = "09 : 00",place = "Balashov", orgs = "FSO Balashov")
        )
        eventCalendarAdapter.setData(list)
    }
}