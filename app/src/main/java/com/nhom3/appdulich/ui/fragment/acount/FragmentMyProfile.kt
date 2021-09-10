package com.nhom3.appdulich.ui.fragment.acount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentProfileBinding
import com.nhom3.appdulich.extension.navigate
import com.nhom3.appdulich.extension.setUpToolbar
import com.nhom3.appdulich.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentMyProfile : BaseFragment<FragmentProfileBinding>(), View.OnClickListener {
    private val _viewModel by activityViewModels<ProfileViewModel>()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentProfileBinding =
        DataBindingUtil.inflate(layoutInflater, R.layout.fragment_profile, container, false)

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
        initView()
        onClickView()
    }

    private fun onClickView() {
        binding.txtUpdate.setOnClickListener(this)
    }

    private fun initView() {
        binding.toolbar.toolbar.setUpToolbar {
            requireActivity().onBackPressed()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.txtUpdate -> requireView().navigate(R.id.action_fragmentMyProfile_to_fragmentUpdateProfile)
        }
    }
}