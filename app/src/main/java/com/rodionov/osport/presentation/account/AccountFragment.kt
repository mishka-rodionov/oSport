package com.rodionov.osport.presentation.account

import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : BaseFragment(R.layout.fragment_account) {

    override val toolbarTitle = R.string.toolbar_title_account

    override fun initViews() {

        clAccount.setOnClickListener {
            hideSoftKeyboard()
        }

    }

}