package com.nhom3.appdulich.ui.page

import com.nhom3.appdulich.base.BaseActivity
import com.nhom3.appdulich.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun listenerViewModel() {
    }

    override fun onInit() {

    }

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)
}