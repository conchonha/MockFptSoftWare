package com.nhom3.appdulich.ui.fragment.acount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentVerifyAccountBinding
import com.nhom3.appdulich.extension.navigate
import com.nhom3.appdulich.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentVerifyAccount : BaseFragment<FragmentVerifyAccountBinding>(), View.OnClickListener {
    private val _viewModel by activityViewModels<LoginViewModel>()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentVerifyAccountBinding =
        DataBindingUtil.inflate(layoutInflater, R.layout.fragment_verify_account, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = _viewModel
        binding.lifecycleOwner = this
    }

    override fun listenerViewModel() {
        _viewModel.showError = {
            helpers.showAlertDialog(msg = it, context = requireContext())
        }
    }

    override fun onInit() {
        initView()
        onClickView()
    }

    private fun initView() {
        binding.toolbar.toolbar.apply {
            setNavigationIcon(R.drawable.ic_back)
            setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }

    private fun onClickView() {
        binding.btnSend.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSend -> {
                _viewModel.verifyCode {
                    requireView().navigate(R.id.action_fragmentVerifyAccount_to_fragmentNewPassword)
                }
            }
        }
    }
}