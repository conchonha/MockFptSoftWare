package com.nhom3.appdulich.ui.fragment.acount

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentAccountBinding
import com.nhom3.appdulich.extension.navigate
import com.nhom3.appdulich.viewmodel.SettingAccountViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentAccount : BaseFragment<FragmentAccountBinding>() {
    private val _viewModel by activityViewModels<SettingAccountViewModel>()

    override fun getViewBinding() = FragmentAccountBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = _viewModel
        binding.lifecycleOwner = this

        _viewModel.getAccount()
    }

    override fun listenerViewModel() {
        _viewModel.showError = {
            helpers.showAlertDialog(msg = it, context = requireContext())
        }
    }

    override fun onInit() {
        onClickView()
    }

    private fun onClickView() {
        binding.rowAccountProfile.relativeGroup.setOnClickListener {
            requireView().navigate(R.id.action_fragmentAcount_to_fragmentMyProfile)
        }

        binding.rowAccountChangePass.relativeGroup.setOnClickListener {
            requireView().navigate(R.id.action_fragmentAcount_to_fragmentChangePassword)
        }

        binding.rowAccountSupport.relativeGroup.setOnClickListener {

        }

        binding.rowAccountAbout.relativeGroup.setOnClickListener {

        }

        binding.rowAccountSetting.relativeGroup.setOnClickListener {

        }

        binding.rowAccountLogout.relativeGroup.setOnClickListener {

        }
    }
}