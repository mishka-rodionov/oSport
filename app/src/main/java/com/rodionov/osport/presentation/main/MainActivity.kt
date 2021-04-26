package com.rodionov.osport.presentation.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.viewbinding.ViewBinding
import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseActivity
import com.rodionov.osport.app.platform.BaseViewModel
import com.rodionov.osport.databinding.ActivityMainBinding

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
            AppBarConfiguration(setOf(R.id.profileFragment, R.id.eventCenterFragment, R.id.eventNewsFragment), drawerLayout = null)
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
