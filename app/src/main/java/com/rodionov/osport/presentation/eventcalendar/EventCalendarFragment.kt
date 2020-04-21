package com.rodionov.osport.presentation.eventcalendar

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.rodionov.osport.R
import com.rodionov.osport.app.extensions.setData
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.presentation.eventcalendar.delegates.EventCalendarItem
import com.rodionov.osport.presentation.eventcalendar.delegates.eventCalendarDelegates
import kotlinx.android.synthetic.main.fragment_event_calendar.*

/**
 * Created by rodionov on 30.03.2020.
 */
class EventCalendarFragment : BaseFragment(R.layout.fragment_event_calendar) {

    override val toolbarTitle = R.string.toolbar_title_calendar

    private val eventCalendarAdapter by lazy {
        ListDelegationAdapter(
            eventCalendarDelegates()
        )
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