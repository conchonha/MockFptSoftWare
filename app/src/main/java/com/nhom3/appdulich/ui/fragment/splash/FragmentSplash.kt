package com.nhom3.appdulich.ui.fragment.splash

import android.os.Handler
import android.os.Looper
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentSplashBinding
import com.nhom3.appdulich.extension.navigate
import com.nhom3.appdulich.utils.SharePrefs
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentSplash : BaseFragment<FragmentSplashBinding>() {
    @Inject
    lateinit var sharePrefs: SharePrefs

    override fun getViewBinding() = FragmentSplashBinding.inflate(layoutInflater)

    override fun listenerViewModel() {

    }

    override fun onInit() {
        val id = if (sharePrefs.getStarted())
            R.id.action_fragmentSplash_to_fragmentLogin else
            R.id.action_fragmentSplash_to_fragmentIntroduce

        Handler(Looper.myLooper()!!).postDelayed({
            requireView().navigate(id)
        }, 3000)
    }
}