package com.rodionov.osport.presentation.profile

import androidx.viewbinding.ViewBinding
import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.databinding.FragmentNewsBinding
import com.rodionov.osport.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment() {

    private val viewModel : ProfileViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    override fun bindingInflater() = FragmentProfileBinding.inflate(layoutInflater)

    override fun initViews() {
        tvProfile.setOnClickListener {
            viewModel.navigateToNewEvent()
        }
    }

}