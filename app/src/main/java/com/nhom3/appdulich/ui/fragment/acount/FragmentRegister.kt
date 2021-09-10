package com.nhom3.appdulich.ui.fragment.acount

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentRegisterBinding
import com.nhom3.appdulich.extension.navigate
import com.nhom3.appdulich.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentRegister : BaseFragment<FragmentRegisterBinding>(), View.OnClickListener {
    private val _viewModel by viewModels<RegisterViewModel>()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentRegisterBinding = DataBindingUtil.inflate(
        layoutInflater,
        R.layout.fragment_register,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = _viewModel
        binding.lifecycleOwner = this
    }

    override fun listenerViewModel() {
        _viewModel.loadingDialog = {
            helpers.showProgressLoading(requireContext())
        }
        _viewModel.showError = {
            helpers.showAlertDialog(msg = it, context = requireContext())
            helpers.dismissProgress()
        }
    }

    override fun onInit() {
        onClickView()
    }

    private fun onClickView() {
        binding.txtBack.setOnClickListener(this)
        binding.btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.txtBack -> requireActivity().onBackPressed()
            R.id.btnRegister -> _viewModel.register {
                helpers.dismissProgress()
                requireView().navigate(R.id.action_fragmentRegister_to_fragmentHome)
            }
        }
    }
}