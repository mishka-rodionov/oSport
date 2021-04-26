package com.rodionov.osport.presentation.registration

import androidx.viewbinding.ViewBinding
import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.databinding.FragmentRegistrationBinding
import kotlinx.android.synthetic.main.fragment_registration.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : BaseFragment(){

    override val toolbarTitle = R.string.toolbar_title_registration

    private val viewModel : RegistrationViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    override fun bindingInflater() = FragmentRegistrationBinding.inflate(layoutInflater)

    override fun initViews() {
        btnSignUpRegistration.setOnClickListener {
            viewModel.navigateToAccount()
        }
    }

}