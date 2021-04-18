package com.rodionov.osport.app.platform

import android.content.Context
import android.content.res.Configuration
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.orgkhim.tm.app.extensions.getCompatColor
import com.rodionov.osport.R
import com.rodionov.osport.app.extensions.observeEvent
import com.rodionov.osport.app.extensions.setStatusBarColor
import com.rodionov.osport.app.extensions.setStatusBarLightMode
import com.rodionov.osport.app.extensions.showToast
import kotlinx.android.synthetic.main.layout_progress.*


abstract class BaseActivity(@LayoutRes val layoutResId: Int) : AppCompatActivity() {

    open val screenViewModel: BaseViewModel?
        get() = null

    open val statusBarColor = R.color.colorStatusBar
    open val statusBarLightMode = true

    private val rootView
        get() = (this.findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup

    private var snackBar: Snackbar? = null

//    abstract fun initInterface(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)

        this.setStatusBarColor(this.getCompatColor(statusBarColor))
        this.setStatusBarLightMode(statusBarLightMode)

        observeBaseLiveData()
    }

    abstract fun initViews()

    abstract fun initToolbar()

    protected fun setupNavigationMenu(navController: NavController, navViewId: Int) {
        val navView = findViewById<NavigationView>(navViewId)
        navView?.setupWithNavController(navController)
    }

    protected fun setupActionBar(navController: NavController,
                                 appBarConfig : AppBarConfiguration
    ) {
        setupActionBarWithNavController(navController, appBarConfig)
    }

    open fun observeBaseLiveData() {
        screenViewModel?.let { vm ->
            observeEvent(vm.mainState, ::handleState)
            observeEvent(vm.message, ::showToast)
        }
    }

    open fun handleState(state: State) {
        snackBar?.dismiss()
        when (state) {
            is State.Loading -> {
                progressStatus(View.VISIBLE)
            }
            is State.Loaded -> {
                progressStatus(View.GONE)
            }
            is State.Error -> {
                progressStatus(View.GONE)
                handleFailure(state.failure)
            }
        }
    }

    private fun progressStatus(visibility: Int) {
        progressLayout?.visibility = visibility
    }

    internal fun dialogNotAlreadyShown(tag: String) =
        supportFragmentManager.findFragmentByTag(tag) == null

    internal fun notify(@StringRes title: Int, @StringRes message: Int) {
        if (dialogNotAlreadyShown(CommonDialog.TAG)) {
            CommonDialog.Builder()
                .cancelVisible(false)
                .btnOk(R.string.btn_ok)
                .title(getString(title))
                .message(getString(message))
                .tag(DIALOG_ERROR_TAG)
                .cancelable(false)
                .build()
                .show(supportFragmentManager, CommonDialog.TAG)
        }
    }

    open fun handleOnlyFailure(state: State?) {
        if (state is State.Error) {
            handleFailure(state.failure)
        }
    }

    open fun handleFailure(failure: Failure?) {
//        when (failure) {
//            is Failure.ServerError -> if (dialogNotAlreadyShown(DIALOG_FULL_SCREEN_TAG)) FullScreenDialog.newInstance(R.layout.dialog_server_error, R.string.label_server_error, R.string.label_server_error_description).show(supportFragmentManager, DIALOG_FULL_SCREEN_TAG)
//            is Failure.AuthError -> notify(R.string.label_auth_error, R.string.label_auth_error_description)
//            is Failure.CommonError -> if (dialogNotAlreadyShown(DIALOG_FULL_SCREEN_TAG)) FullScreenDialog.newInstance(R.layout.dialog_server_error, R.string.label_common_error, R.string.label_common_error_description).show(supportFragmentManager, DIALOG_FULL_SCREEN_TAG)
//            is Failure.UnacceptableFormatError -> notify(R.string.label_unacceptable_format_error, R.string.label_unacceptable_format_error_description)
//            is Failure.UploadingError -> notify( R.string.label_uploading_error, R.string.label_uploading_error_description)
//            is Failure.NetworkConnection -> if (dialogNotAlreadyShown(DIALOG_FULL_SCREEN_TAG)) FullScreenDialog.newInstance(R.layout.fragment_connection_error).show(supportFragmentManager, DIALOG_FULL_SCREEN_TAG)
//        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    v.clearFocus()
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    override fun attachBaseContext(base: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            super.attachBaseContext(LocaleHelper.onAttach(base))
        } else {
            super.attachBaseContext(base)
        }
    }

    override fun applyOverrideConfiguration(overrideConfiguration: Configuration) {
        super.applyOverrideConfiguration(baseContext.resources.configuration)
    }

    companion object {
        const val DIALOG_ERROR_TAG = "DialogError"
    }
}
