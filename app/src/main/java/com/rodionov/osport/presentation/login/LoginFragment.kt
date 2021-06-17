package com.rodionov.osport.presentation.login

import android.util.Log
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.app.platform.NavigationEvent
import com.rodionov.osport.app.utils.Logger.TAG
import com.rodionov.osport.data.dto.requests.LoginRequest
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
        binding.ccpUserLogin.registerCarrierNumberEditText(binding.etUserLoginCarrierNumber)
        btnSignIn.setOnClickListener {
//            if (viewModel.checkPassword(binding.))
            Log.d(TAG, "initViews: formatted number ${binding.ccpUserLogin.formattedFullNumber}")
            Log.d(TAG, "initViews: unformatted number ${binding.ccpUserLogin.fullNumber}")
            Log.d(TAG, "initViews: unformatted number with prefix ${binding.ccpUserLogin.fullNumberWithPlus}")
//            viewModel.navigateToProfile()
            viewModel.userLogin(
                phonePrefix = binding.ccpUserLogin.selectedCountryCodeWithPlus,
                phone = binding.ccpUserLogin.fullNumberWithPlus.removePrefix(binding.ccpUserLogin.selectedCountryCodeWithPlus),
                password = binding.etPassword.text.toString()
            )
        }

        btnSignUp.setOnClickListener {
            viewModel.navigate(NavigationEvent.PushFragment(action = R.id.registrationFragment))
        }
    }


}