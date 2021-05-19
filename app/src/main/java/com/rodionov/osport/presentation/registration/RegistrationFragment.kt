package com.rodionov.osport.presentation.registration

import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.redmadrobot.inputmask.MaskedTextChangedListener
import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.databinding.FragmentAccountBinding
import com.rodionov.osport.databinding.FragmentRegistrationBinding
import kotlinx.android.synthetic.main.fragment_registration.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : BaseFragment(R.layout.fragment_registration){

    private val binding: FragmentRegistrationBinding by viewBinding()

    override val toolbarTitle = R.string.toolbar_title_registration

    private val viewModel : RegistrationViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

    override fun initViews() {
        MaskedTextChangedListener.installOn(
            editText = binding.etUserPhone,
            primaryFormat = getString(R.string.phone_format),
            valueListener = object : MaskedTextChangedListener.ValueListener {
                override fun onTextChanged(
                    maskFilled: Boolean,
                    extractedValue: String,
                    formattedValue: String
                ) {
//                    presenter.changePhone(formattedValue)
                }
            }
        )
    }

}