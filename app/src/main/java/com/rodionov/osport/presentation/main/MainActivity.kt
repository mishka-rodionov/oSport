package com.rodionov.osport.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ncapdevi.fragnav.FragNavController
import com.ncapdevi.fragnav.FragNavController.Companion.TAB1
import com.ncapdevi.fragnav.FragNavController.Companion.TAB2
import com.ncapdevi.fragnav.FragNavController.Companion.TAB3
import com.ncapdevi.fragnav.FragNavSwitchController
import com.ncapdevi.fragnav.FragNavTransactionOptions
import com.ncapdevi.fragnav.tabhistory.UniqueTabHistoryStrategy
import com.rodionov.osport.R
import com.rodionov.osport.app.extensions.gone
import com.rodionov.osport.app.extensions.show
import com.rodionov.osport.app.platform.BaseActivity
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.app.platform.FragmentNavigation
import com.rodionov.osport.presentation.eventcalendar.EventCalendarFragment
import com.rodionov.osport.presentation.news.NewsFragment
import com.rodionov.osport.presentation.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main), FragmentNavigation, FragNavController.RootFragmentListener {

    override val screenViewModel: BaseViewModel?
        get() = super.screenViewModel

    private val fragNavController by lazy {
        FragNavController(supportFragmentManager, R.id.container)
    }

    private val tabs = arrayListOf(
        R.id.tab_news to NewsFragment(),
        R.id.tab_events to EventCalendarFragment(),
        R.id.tab_profile to ProfileFragment()
    )

    override fun initInterface(savedInstanceState: Bundle?) {
        setupBottomNavigation(savedInstanceState)
    }

    private fun setupBottomNavigation(saveInstanceState: Bundle?) {
        val navigationItemListener = BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.tab_news -> fragNavController.switchTab(TAB1)
                R.id.tab_events -> fragNavController.switchTab(TAB2)
                R.id.tab_profile -> fragNavController.switchTab(TAB3)
            }
            true
        }

        fragNavController.apply {
            rootFragmentListener = this@MainActivity
            fragmentHideStrategy = FragNavController.DETACH
            navigationStrategy = UniqueTabHistoryStrategy(object : FragNavSwitchController {
                override fun switchTab(index: Int, transactionOptions: FragNavTransactionOptions?) {
                    bottomNavigation.selectedItemId = tabs[index].first
                }
            })
        }

        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemListener)
        bottomNavigation.setOnNavigationItemReselectedListener { fragNavController.clearStack() }

        fragNavController.initialize(TAB1, saveInstanceState)
    }

    override val numberOfRootFragments = tabs.size

    override fun getRootFragment(index: Int) = tabs[index].second

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        fragNavController.onSaveInstanceState(outState)
    }

    override fun switchTab(index: Int) {
        bottomNavigation.selectedItemId = tabs[index].first
        fragNavController.switchTab(index)
    }

    override fun pushFragment(fragment: BaseFragment) {
        fragNavController.pushFragment(fragment)
    }

    override fun popFragment() {
        fragNavController.popFragment()
    }

    override fun popFragments(count: Int) {
        fragNavController.popFragments(count)
    }

    override fun clearStack() {
        fragNavController.clearStack()
    }

    override fun showDialogFragment(dialogFragment: DialogFragment) {
        fragNavController.showDialogFragment(dialogFragment)
    }

    override fun canGoBack(): Boolean {
        return fragNavController.currentStack?.size?.let { size ->
            size > 1
        } ?: false
    }

    override fun showBottomNavigation() {
        if (bottomNavigation.visibility != View.VISIBLE) {
            bottomNavigation?.show()
        }
    }

    override fun hideBottomNavigation() {
        if (bottomNavigation.visibility != View.GONE) {
            bottomNavigation?.gone()
        }
    }
}
