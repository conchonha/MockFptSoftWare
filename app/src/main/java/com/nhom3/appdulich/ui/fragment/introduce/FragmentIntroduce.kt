package com.nhom3.appdulich.ui.fragment.introduce

import androidx.viewpager2.widget.ViewPager2
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentIntroduceBinding
import com.nhom3.appdulich.ui.adapter.IntroduceAdapter

class FragmentIntroduce : BaseFragment<FragmentIntroduceBinding>() {
    private val _adapter by lazy { IntroduceAdapter(childFragmentManager, lifecycle) }

    override fun getViewBinding() = FragmentIntroduceBinding.inflate(layoutInflater)

    override fun listenerViewModel() {

    }

    override fun onInit() {
        initView()
    }

    private fun initView() {
        binding.viewPager.apply {
            adapter = _adapter
            binding.pageIndicator.count = _adapter.itemCount

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.pageIndicator.selection = position
                }
            })
        }
    }
}