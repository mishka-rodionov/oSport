package com.rodionov.base.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.orgkhim.tm.app.extensions.getCompatColor
import com.rodionov.base.R
import com.rodionov.base.extensions.observeEvent
import com.rodionov.base.extensions.setStatusBarColor
import com.rodionov.base.extensions.setStatusBarLightMode
import com.rodionov.base.platform.CommonDialog
import com.rodionov.base.platform.Failure
import com.rodionov.base.platform.NavigationEvent
import com.rodionov.base.platform.State
import com.rodionov.base.viewmodel.BaseViewModel

abstract class BaseFragment(@LayoutRes layout: Int): Fragment(layout) {

    open val supportFragmentManager
        get() = requireActivity().supportFragmentManager

    open val screenViewModel: BaseViewModel?
        get() = null

    open val statusBarColor = R.color.colorStatusBar
    open val statusBarLightMode = true

    open val toolbarTitle: Int? = null
    open val toolbarDrawableClose: Int? = null

    private var snackBar: Snackbar? = null
    protected var navigationController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navigationController = findNavController()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.setStatusBarColor(requireActivity().getCompatColor(statusBarColor))
        activity?.setStatusBarLightMode(statusBarLightMode)

        setToolbarTitle()
        initViews()
        observeBaseLiveData()
    }

    abstract fun initViews()

    open fun observeBaseLiveData() {
        screenViewModel?.let { vm ->
            observeEvent(vm.mainState, ::handleState)
//            observeEvent(vm.message, ::showToast)
            observeEvent(vm.fragmentNavigation, ::handleFragmentNavigation)
        }
    }


    override fun onDestroyView() {
        snackBar?.dismiss()
        super.onDestroyView()
    }

    private fun handleFragmentNavigation(event: NavigationEvent) {
        when (event) {
            NavigationEvent.ClearStack -> navigationController
            NavigationEvent.Exit -> navigationController?.popBackStack()
            is NavigationEvent.PushFragment -> {
                if (event.navOptions != null)
                    navigationController?.navigate(event.action, event.bundle, event.navOptions)
                else
                    navigationController?.navigate(event.action, event.bundle)
            }
        }
    }

    internal fun dialogNotAlreadyShown(tag: String) =
        supportFragmentManager.findFragmentByTag(tag) == null

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

    private fun progressStatus(visibility: Int) = view?.let {
//        it.progressLayout?.visibility = visibility
    }

    private fun setToolbarTitle() {
//        tvToolbarTitle?.text = toolbarTitle?.let { resources.getString(it) }
//        ivFilterRequests?.isVisible = toolbarIconFilterVisible
//
//        if (toolbarTextButtonConfirm != null) {
//            tvButtonConfirm?.text = resources.getString(toolbarTextButtonConfirm!!)
//        } else {
//            tvButtonConfirm?.gone()
//        }
//
//        if (toolbarDrawableClose != null) {
//            ivClose?.setImageDrawable(resources.getDrawable(toolbarDrawableClose!!, null))
//        } else {
//            ivClose?.gone()
//        }
//
//        if (!statusBarLightMode) {
//            toolbar?.setBackgroundColor(resources.getColor(R.color.colorPrimary, null))
//            tvToolbarTitle?.style(R.style.Text_Bold_White_20)
//            viewToolbar?.setBackgroundColor(resources.getColor(R.color.colorWhiteTransparent, null))
//        }
//
//        ivClose?.setOnClickListener {
//            fragmentNavigation?.popFragment()
//        }
    }

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
                .apply {
                    setTargetFragment(this@BaseFragment, 0)
                }
                .show(supportFragmentManager, CommonDialog.TAG)
        }
    }

    override fun onStop() {
        super.onStop()
        hideSoftKeyboard()
    }

    fun showSoftKeyboard(field: View?) {
        field?.let {
            val imm =
                activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.showSoftInput(it, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun hideSoftKeyboard() {
        view?.let {
            val imm =
                activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    protected fun setKeyboardModPan() {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

    protected fun setKeyboardModResize() {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    protected fun setKeyboardModResizeAndHidden() {
        activity?.window?.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                    or WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        )
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
//            is Failure.NetworkConnection -> fragmentNavigation?.pushFragment(ConnectionErrorFragment())
//        }
    }

    companion object {
        const val DIALOG_ERROR_TAG = "DialogError"
    }
}
