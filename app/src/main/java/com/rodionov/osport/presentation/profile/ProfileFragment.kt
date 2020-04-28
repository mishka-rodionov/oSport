package com.rodionov.osport.presentation.profile

import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    private val viewModel : ProfileViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    override fun initViews() {
        tvProfile.setOnClickListener {
            viewModel.navigateToNewEvent()
        }
    }

}