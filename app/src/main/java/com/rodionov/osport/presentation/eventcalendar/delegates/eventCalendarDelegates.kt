package com.rodionov.osport.presentation.eventcalendar.delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateLayoutContainer
import com.rodionov.osport.R
import kotlinx.android.synthetic.main.item_event_calendar.view.*


fun eventCalendarDelegates() =
    adapterDelegateLayoutContainer<EventCalendarItem, Any>(R.layout.item_event_calendar) {

        bind {
            containerView.tvEventDate.text = item.date
            containerView.tvEventTime.text = item.time
            containerView.tvEventPlace.text = item.place
            containerView.tvEventOrganizers.text = item.orgs
        }

    }

data class EventCalendarItem(
    val date: String,
    val time: String,
    val place: String,
    val orgs: String
)