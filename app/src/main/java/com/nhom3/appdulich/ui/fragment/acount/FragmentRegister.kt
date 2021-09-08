package com.nhom3.appdulich.ui.fragment.acount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentRegisterBinding

class FragmentRegister : BaseFragment<FragmentRegisterBinding>() {
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

    override fun listenerViewModel() {
    }

    override fun onInit() {
        onClickView()
    }

    private fun onClickView() {
        binding.txtBack.setOnClickListener { requireActivity().onBackPressed() }
    }
}