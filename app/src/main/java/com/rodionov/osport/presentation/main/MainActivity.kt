package com.rodionov.osport.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ncapdevi.fragnav.FragNavController
import com.ncapdevi.fragnav.FragNavController.Companion.TAB1
import com.ncapdevi.fragnav.FragNavController.Companion.TAB2
import com.ncapdevi.fragnav.FragNavController.Companion.TAB3
import com.ncapdevi.fragnav.FragNavSwitchController
import com.ncapdevi.fragnav.FragNavTransactionOptions
import com.ncapdevi.fragnav.tabhistory.UniqueTabHistoryStrategy
import com.ncapdevi.fragnav.tabhistory.UnlimitedTabHistoryController
import com.ncapdevi.fragnav.tabhistory.UnlimitedTabHistoryStrategy
import com.rodionov.osport.R
import com.rodionov.osport.app.extensions.gone
import com.rodionov.osport.app.extensions.show
import com.rodionov.osport.app.platform.BaseActivity
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.app.platform.FragmentNavigation
import com.rodionov.osport.databinding.ActivityMainBinding
import com.rodionov.osport.presentation.eventcalendar.EventCalendarFragment
import com.rodionov.osport.presentation.login.LoginFragment
import com.rodionov.osport.presentation.news.NewsFragment
import com.rodionov.osport.presentation.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(){

    override val screenViewModel: BaseViewModel?
        get() = super.screenViewModel

    lateinit var appBarConfiguration: AppBarConfiguration

    lateinit var host: NavHostFragment
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun bindingInflater(): ViewBinding {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding
    }

    override fun initToolbar() {
    }

    override fun initViews() {
        host = supportFragmentManager
            .findFragmentById(R.id.container) as NavHostFragment? ?: return
        navController = host.navController
        setupObserver()
        setupBottomNavMenu(navController = navController)
        appBarConfiguration =
            AppBarConfiguration(navController.graph, drawerLayout = null)
//        setupActionBar(navController, appBarConfiguration)
    }

    private fun setupObserver() {}

    private fun setupBottomNavMenu(navController: NavController) {
        setupNavigationMenu(navController, (binding as ActivityMainBinding).bottomNavigation)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.container).navigateUp(appBarConfiguration)
    }

    override fun onBackPressed() {
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

}
