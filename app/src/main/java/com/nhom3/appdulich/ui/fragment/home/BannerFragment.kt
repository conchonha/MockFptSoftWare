package com.nhom3.appdulich.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentBannerBinding
import com.nhom3.appdulich.extension.navigate
import com.nhom3.appdulich.ui.adapter.home.BannerAdapter
import com.nhom3.appdulich.utils.Const
import com.nhom3.appdulich.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BannerFragment : BaseFragment<FragmentBannerBinding>() {
    private val _viewModel by activityViewModels<HomeViewModel>()

    @Inject
    lateinit var adapterBanner: BannerAdapter

    override fun getViewBinding() = FragmentBannerBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
        _viewModel.showError = {
            helpers.showToast(it)
        }

        _viewModel.getDataBannerRandom {
            helpers.dismissProgress()
            it.observe(viewLifecycleOwner, {
                adapterBanner.updateItems(it.toMutableList())
            })
            binding.pageIndicatorViewBanner.count = adapterBanner.itemCount
        }
    }

    override fun onInit() {
        initView()
    }

    private fun initView() {
        binding.viewpagerBanner.apply {
            adapter = adapterBanner

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.pageIndicatorViewBanner.selection = position
                }
            })

            adapterBanner.listener = { view, item, position ->
                requireView().navigate(R.id.action_global_fragmentDetailPlace, Bundle().apply {
                    putInt(Const.KEY_ID, item.id)
                })
            }
        }
    }
}