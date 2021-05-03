package com.rodionov.osport.presentation.account

import androidx.viewbinding.ViewBinding
import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.databinding.FragmentAccountBinding
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : BaseFragment() {

    override val toolbarTitle = R.string.toolbar_title_account

    override fun initViews() {

        clAccount.setOnClickListener {
            hideSoftKeyboard()
        }

    }

    override fun bindingInflater() = FragmentAccountBinding.inflate(layoutInflater)

}