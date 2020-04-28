package com.rodionov.osport.presentation.registration

import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_registration.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : BaseFragment(R.layout.fragment_registration){

    override val toolbarTitle = R.string.toolbar_title_registration

    private val viewModel : RegistrationViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    override fun initViews() {
        btnSignUpRegistration.setOnClickListener {
            viewModel.navigateToAccount()
        }
    }

}