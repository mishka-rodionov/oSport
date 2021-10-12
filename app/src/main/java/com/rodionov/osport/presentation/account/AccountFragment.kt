package com.rodionov.osport.presentation.account

import by.kirich1409.viewbindingdelegate.viewBinding
import com.rodionov.osport.R
import com.rodionov.base.ui.BaseFragment
import com.rodionov.osport.databinding.FragmentAccountBinding
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : BaseFragment(R.layout.fragment_account) {

    private val binding: FragmentAccountBinding by viewBinding()

    override val toolbarTitle = R.string.toolbar_title_account

    override fun initViews() {

        clAccount.setOnClickListener {
            hideSoftKeyboard()
        }

    }

}