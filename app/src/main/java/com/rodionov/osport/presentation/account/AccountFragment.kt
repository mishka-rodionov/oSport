package com.rodionov.osport.presentation.account

import com.rodionov.osport.R
import com.rodionov.base.ui.BaseFragment
import com.rodionov.osport.databinding.FragmentAccountBinding
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : com.rodionov.base.ui.BaseFragment(R.layout.fragment_account) {

    private val binding: FragmentAccountBinding by viewBinding()

    override val toolbarTitle = R.string.toolbar_title_account

    override fun initViews() {

        clAccount.setOnClickListener {
            hideSoftKeyboard()
        }

    }

}