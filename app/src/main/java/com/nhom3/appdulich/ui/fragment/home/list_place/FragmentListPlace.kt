package com.nhom3.appdulich.ui.fragment.home.list_place

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentIngredientBinding
import com.nhom3.appdulich.extension.listener
import com.nhom3.appdulich.extension.navigate
import com.nhom3.appdulich.extension.setUpToolbar
import com.nhom3.appdulich.ui.adapter.home.ingredient.BannerAdapter
import com.nhom3.appdulich.ui.adapter.home.list_place.ListPlaceAdapter
import com.nhom3.appdulich.utils.Const
import com.nhom3.appdulich.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentListPlace : BaseFragment<FragmentIngredientBinding>() {
    private var _id: Int? = null
    private val _viewModel by activityViewModels<HomeViewModel>()

    @Inject
    lateinit var adapterBanner: BannerAdapter

    @Inject
    lateinit var adapterListPlace: ListPlaceAdapter

    override fun getViewBinding() = FragmentIngredientBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
        _id?.let {
            _viewModel.getListPlaceIdIngredient(it) { liveData ->
                helpers.dismissProgress()
                liveData.observe(viewLifecycleOwner, {
                    adapterBanner.updateItems(it.toMutableList())
                    adapterListPlace.updateItems(it.toMutableList())
                    binding.pageIndicatorViewBanner.count = adapterBanner.itemCount
                })
            }
        }
    }

    override fun onInit() {
        initView()
        onClickView()
    }

    private fun onClickView() {
        binding.imgBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun initView() {
        arguments?.apply {
            _id = getInt(Const.KEY_ID)
            binding.collapsingToolbarLayout.title = getString(Const.KEY_NAME)
        }

        //appbar layout
        binding.collapsingToolbarLayout.apply {
            setExpandedTitleColor(requireContext().getColor(R.color.white))
            setCollapsedTitleTextColor(requireContext().getColor(R.color.white))
        }

        //setIcon toolbar
        binding.toolbar.toolbar.apply {
            setBackgroundColor(context.getColor(R.color.colorPrimary))
            setUpToolbar {}
        }

        //appbar layout
        binding.appBarLayout.listener(onSuccess = {
            binding.viewPager.visibility = View.GONE
            binding.toolbar.toolbar.visibility = View.VISIBLE
        }, onFail = {
            binding.viewPager.visibility = View.VISIBLE
            binding.toolbar.toolbar.visibility = View.INVISIBLE
        })

        //recycler
        binding.recyclerPlace.apply {
            isNestedScrollingEnabled = false
            adapter = adapterListPlace
            adapterListPlace.listener = { view, item, position ->
                requireView().navigate(R.id.action_global_fragmentDetailPlace, Bundle().apply {
                    putInt(Const.KEY_ID, item.id)
                })
            }
        }

        //viewpager
        binding.viewPager.apply {
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