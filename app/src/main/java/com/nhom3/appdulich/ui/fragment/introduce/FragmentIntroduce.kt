package com.nhom3.appdulich.ui.fragment.introduce

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentIntroduceBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentIntroduce : BaseFragment<FragmentIntroduceBinding>() {
    @Inject
    lateinit var adapterIntroduce: IntroduceAdapter

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentIntroduceBinding = FragmentIntroduceBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
    }

    override fun onInit() {
        initView()
    }

    private fun initView() {
        binding.vpmain.apply {
            adapter = adapterIntroduce
            adapterIntroduce.notifyDataSetChanged()
            binding.pageIncator.setViewPager(this)
        }

        Log.d("AAA", "initView: ${adapterIntroduce}")
    }
}