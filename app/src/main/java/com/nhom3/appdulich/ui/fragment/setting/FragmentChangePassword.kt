package com.nhom3.appdulich.ui.fragment.setting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentChangePasswordBinding
import com.nhom3.appdulich.viewmodel.SettingAccountViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentChangePassword : BaseFragment<FragmentChangePasswordBinding>(),View.OnClickListener {
    private val _viewModel by activityViewModels<SettingAccountViewModel>()

    override fun getViewBinding() = FragmentChangePasswordBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = _viewModel
        binding.lifecycleOwner = this
    }

    override fun listenerViewModel() {
        _viewModel.showError = {
            helpers.showAlertDialog(msg = it, context = requireContext())
            helpers.dismissProgress()
        }

        _viewModel.loadingDialog = {
            helpers.showProgressLoading(requireContext())
        }
    }

    override fun onInit() {
        onClickView()
    }

    private fun onClickView() {
        binding.imgBack.setOnClickListener(this)
        binding.btnChange.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.imgBack -> requireActivity().onBackPressed()
            R.id.btnChange -> _viewModel.changePassword {
                requireActivity().onBackPressed()
                helpers.showToast(getString(R.string.lbl_change_password_success))
                helpers.dismissProgress()
            }
        }
    }
}