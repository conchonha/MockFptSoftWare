package com.nhom3.appdulich.ui.fragment.acount

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentNewPasswordBinding
import com.nhom3.appdulich.extension.navigate
import com.nhom3.appdulich.viewmodel.account.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentNewPassword : BaseFragment<FragmentNewPasswordBinding>(), View.OnClickListener {
    private val _viewModel by activityViewModels<LoginViewModel>()

    override fun getViewBinding() = FragmentNewPasswordBinding.inflate(layoutInflater)

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
        binding.btnAgree.setOnClickListener(this)
        binding.imgBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnAgree -> _viewModel.newPassword {
                helpers.dismissProgress()
                helpers.showToast(getString(R.string.lbl_update_password_success))
                requireView().navigate(R.id.action_fragmentNewPassword_to_fragmentLogin)
            }
            R.id.imgBack -> requireActivity().onBackPressed()
        }
    }
}