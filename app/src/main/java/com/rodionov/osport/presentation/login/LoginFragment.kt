package com.rodionov.osport.presentation.login

import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.databinding.FragmentAccountBinding
import com.rodionov.osport.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val binding: FragmentLoginBinding by viewBinding()

    override val toolbarTitle = R.string.toolbar_title_enter

    private val viewModel : LoginViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    override fun initViews() {
        btnSignIn.setOnClickListener {
            viewModel.navigateToProfile()
        }

        btnSignUp.setOnClickListener {
            viewModel.navigateToRegistration()
        }
    }


}