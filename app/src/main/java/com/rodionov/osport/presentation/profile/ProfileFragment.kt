package com.rodionov.osport.presentation.profile

import android.os.Bundle
import com.rodionov.osport.R
import com.rodionov.base.ui.BaseFragment
import com.rodionov.osport.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : com.rodionov.base.ui.BaseFragment(R.layout.fragment_profile) {

    private val viewModel: ProfileViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    private val binding: FragmentProfileBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!viewModel.checkAuthorization()) {
            viewModel.navigateToLogin(action = R.id.action_profileFragment_to_loginFragment)
        } else {
            viewModel.getUser()
        }
    }

    private fun setupObservers() {
        viewModel.user.observe(viewLifecycleOwner) {
            binding.tvProfileUserName.text =
                getString(R.string.profile_fullname_pattern, it.lastName, it.firstName)
            binding.tvProfilePhone.text = it.phoneCountryPrefix + it.phoneNumber
        }
    }

    override fun initViews() {
        setupObservers()
    }

}