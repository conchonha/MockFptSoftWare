package com.nhom3.appdulich.ui.fragment.acount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentUpdateProfileBinding
import com.nhom3.appdulich.extension.setUpToolbar
import com.nhom3.appdulich.viewmodel.ProfileViewModel

class FragmentUpdateProfile : BaseFragment<FragmentUpdateProfileBinding>() {
    private val _viewModel by activityViewModels<ProfileViewModel>()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentUpdateProfileBinding =
        DataBindingUtil.inflate(layoutInflater, R.layout.fragment_update_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = _viewModel
        binding.lifecycleOwner = this
    }

    override fun listenerViewModel() {

    }

    override fun onInit() {
        initView()
        onClickView()
    }

    private fun onClickView() {

    }

    private fun initView() {
        binding.toolbar.toolbar.setUpToolbar {
            requireActivity().onBackPressed()
        }
    }
}