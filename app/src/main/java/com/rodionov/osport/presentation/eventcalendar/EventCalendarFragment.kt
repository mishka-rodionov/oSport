package com.rodionov.osport.presentation.eventcalendar

import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.rodionov.osport.R
import com.rodionov.osport.app.extensions.setData
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.databinding.FragmentAccountBinding
import com.rodionov.osport.databinding.FragmentEventCalendarBinding
import com.rodionov.osport.presentation.eventcalendar.delegates.EventCalendarItem
import com.rodionov.osport.presentation.eventcalendar.delegates.eventCalendarDelegates
import kotlinx.android.synthetic.main.fragment_event_calendar.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by rodionov on 30.03.2020.
 */
class EventCalendarFragment : BaseFragment(R.layout.fragment_event_calendar) {

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