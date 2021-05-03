package com.rodionov.osport.presentation.newevent

import androidx.viewbinding.ViewBinding
import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.databinding.FragmentNewEventBinding
import kotlinx.android.synthetic.main.fragment_new_event.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewEventFragment : BaseFragment() {

    private val viewModel : NewEventViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    override fun bindingInflater() = FragmentNewEventBinding.inflate(layoutInflater)

    override fun initViews() {
        tvGoToMap.setOnClickListener {
            viewModel.navigateToMap()
        }
    }
}