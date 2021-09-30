package com.rodionov.osport.presentation.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.viewbinding.ViewBinding
import com.rodionov.osport.R
import com.rodionov.base.ui.BaseActivity
import com.rodionov.base.viewmodel.BaseViewModel
import com.rodionov.osport.databinding.ActivityMainBinding

class MainActivity : com.rodionov.base.ui.BaseActivity(){

    override val screenViewModel: com.rodionov.base.viewmodel.BaseViewModel?
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
        setSupportActionBar((binding as ActivityMainBinding).toolbarMain.toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun initViews() {
        host = supportFragmentManager
            .findFragmentById(R.id.container) as NavHostFragment? ?: return
        navController = host.navController
        setupObserver()
        setupBottomNavMenu(navController = navController)
        appBarConfiguration =
            AppBarConfiguration(setOf(R.id.profileFragment, R.id.eventCenterFragment, R.id.eventNewsFragment), drawerLayout = null)
        setupActionBar(navController, appBarConfiguration)
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
