package com.rodionov.osport.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseActivity
import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.presentation.eventcalendar.EventCalendarFragment
import com.rodionov.osport.presentation.news.NewsFragment
import com.rodionov.osport.presentation.profile.ProfileFragment

class MainActivity : BaseActivity(R.layout.activity_main) {

    override val screenViewModel: BaseViewModel?
        get() = super.screenViewModel

    private val tabs = arrayListOf(
        R.id.tab_news to NewsFragment(),
        R.id.tab_events to EventCalendarFragment(),
        R.id.tab_profile to ProfileFragment()
    )

    override fun initInterface(savedInstanceState: Bundle?) {

    }
}
