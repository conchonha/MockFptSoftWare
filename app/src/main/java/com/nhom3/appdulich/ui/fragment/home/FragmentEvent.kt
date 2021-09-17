package com.nhom3.appdulich.ui.fragment.home

import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentHomeLayoutBinding
import com.nhom3.appdulich.ui.adapter.home.EventAdapter
import com.nhom3.appdulich.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentEvent : BaseFragment<FragmentHomeLayoutBinding>() {
    private val _viewModel by activityViewModels<HomeViewModel>()

    @Inject
    lateinit var adapterEvent: EventAdapter

    override fun getViewBinding() = FragmentHomeLayoutBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
        _viewModel.showError = {
            helpers.showToast(it)
        }

        _viewModel.getDataEventRanDom {
            it.observe(viewLifecycleOwner, {
                adapterEvent.updateItems(it.toMutableList())
            })
        }
    }

    override fun onInit() {
        initView()
    }

    private fun initView() {
        binding.lifecycleOwner = this
        binding.title = getString(R.string.lbl_event)

        binding.recyclerHome.apply {
            isNestedScrollingEnabled = false
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterEvent

            adapterEvent.listener = { view, item, position ->

            }
        }
    }
}