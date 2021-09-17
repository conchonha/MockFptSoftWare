package com.nhom3.appdulich.ui.fragment.image

import androidx.fragment.app.activityViewModels
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentImageInsideBinding
import com.nhom3.appdulich.extension.setUpToolbar
import com.nhom3.appdulich.ui.adapter.map.AdapterImage
import com.nhom3.appdulich.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentImageInside : BaseFragment<FragmentImageInsideBinding>() {
    private val _viewModel by activityViewModels<HomeViewModel>()
    @Inject
    lateinit var adapterImage: AdapterImage

    override fun getViewBinding() = FragmentImageInsideBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
        _viewModel.loadingDialog = {
            helpers.showProgressLoading(requireContext())
        }

        _viewModel.showError = {
            helpers.showAlertDialog(msg = it, context = requireContext())
            helpers.dismissProgress()
        }

        _viewModel.getAllImagePlace {
            helpers.dismissProgress()
            it.observe(viewLifecycleOwner,{list->
                list.map { it.image!! }.toMutableList().let {
                    adapterImage.updateItems(it)
                }
            })
        }
    }

    override fun onInit() {
        initView()
    }

    private fun initView() {
        binding.toolbar.toolbar.setUpToolbar {
            requireActivity().onBackPressed()
        }

        binding.recyclerImage.apply {
            adapter = adapterImage
            setHasFixedSize(true)
        }
    }
}