package com.nhom3.appdulich.ui.fragment.acount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentVerifyAccountBinding

class FragmentVerifyAccount : BaseFragment<FragmentVerifyAccountBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentVerifyAccountBinding =
        FragmentVerifyAccountBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
    }

    override fun onInit() {
    }
}