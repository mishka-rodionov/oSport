package com.rodionov.osport.presentation.login

import android.widget.Toast
import com.rodionov.osport.R
import com.rodionov.base.ui.BaseFragment
import com.rodionov.base.platform.NavigationEvent
import com.rodionov.osport.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : com.rodionov.base.ui.BaseFragment(R.layout.fragment_login) {

    private val binding: FragmentLoginBinding by viewBinding()

    override val toolbarTitle = R.string.toolbar_title_enter

    private val viewModel : LoginViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    override fun initViews() {
        binding.ccpUserLogin.registerCarrierNumberEditText(binding.etUserLoginCarrierNumber)
        btnSignIn.setOnClickListener {
            viewModel.userLogin(
                phonePrefix = binding.ccpUserLogin.selectedCountryCodeWithPlus,
                phone = binding.ccpUserLogin.fullNumberWithPlus.removePrefix(binding.ccpUserLogin.selectedCountryCodeWithPlus),
                password = binding.etPassword.text.toString()
            )
        }

        btnSignUp.setOnClickListener {
            viewModel.navigate(NavigationEvent.PushFragment(action = R.id.registrationFragment))
        }
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.successfulLogin.observe(viewLifecycleOwner, ::handleLogin)
    }

    private fun handleLogin(result: Boolean) {
        if (result) {
            viewModel.navigateToProfile(R.id.action_loginFragment_to_profileFragment)
        } else {
            //TODO: show error dialog
            Toast.makeText(context, "Wrong username or password", Toast.LENGTH_SHORT).show()
        }
    }


}