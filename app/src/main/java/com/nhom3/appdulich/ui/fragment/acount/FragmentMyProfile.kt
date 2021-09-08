package com.nhom3.appdulich.ui.fragment.acount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentProfileBinding

class FragmentMyProfile : BaseFragment<FragmentProfileBinding>(){
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentProfileBinding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_profile,container,false)

    override fun listenerViewModel() {

    }

    override fun onInit() {

    }
}