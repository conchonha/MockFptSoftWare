package com.nhom3.appdulich.ui.fragment.introduce

import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentSlide3Binding
import com.nhom3.appdulich.extension.navigate
import com.nhom3.appdulich.utils.SharePrefs
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentSlide3 : BaseFragment<FragmentSlide3Binding>() {
    @Inject
    lateinit var sharePrefs: SharePrefs

    override fun getViewBinding() = FragmentSlide3Binding.inflate(layoutInflater)

    override fun listenerViewModel() {
    }

    override fun onInit() {
        onClickView()
    }

    private fun onClickView() {
        binding.btnStarted.setOnClickListener {
            sharePrefs.saveStarted(true)
            requireView().navigate(R.id.action_fragmentIntroduce_to_fragmentLogin)
        }
    }
}