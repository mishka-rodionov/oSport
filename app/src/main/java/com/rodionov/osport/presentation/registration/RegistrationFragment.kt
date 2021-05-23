package com.rodionov.osport.presentation.registration

import by.kirich1409.viewbindingdelegate.viewBinding
import com.redmadrobot.inputmask.MaskedTextChangedListener
import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.databinding.FragmentRegistrationBinding
import com.rodionov.osport.domain.model.User
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

        binding.btnRegistration.setOnClickListener {
            viewModel.register(
                User(
                    id = "",
                    firstName = binding.etUserFirstName.text.toString(),
                    middleName = "",
                    lastName = binding.etUserLastName.text.toString(),
                    phoneCountryPrefix = "+7",
                    phoneNumber = "9271239348",
                    email = "",
                    birthDate = null,
                    sportRanks = null
                )
            )
        }
    }

}