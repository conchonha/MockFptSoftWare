package com.nhom3.appdulich.ui.fragment.acount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentAccountBinding

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

    }
}