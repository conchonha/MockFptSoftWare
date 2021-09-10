package com.nhom3.appdulich.ui.fragment.acount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentAccountBinding
import com.nhom3.appdulich.extension.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentAccount : BaseFragment<FragmentAccountBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentAccountBinding =
        DataBindingUtil.inflate(layoutInflater, R.layout.fragment_account, container, false)

    override fun listenerViewModel() {

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