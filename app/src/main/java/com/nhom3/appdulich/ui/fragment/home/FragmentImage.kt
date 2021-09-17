package com.nhom3.appdulich.ui.fragment.home

import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentHomeLayoutBinding
import com.nhom3.appdulich.extension.navigate
import com.nhom3.appdulich.ui.adapter.map.AdapterImage
import com.nhom3.appdulich.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentImage : BaseFragment<FragmentHomeLayoutBinding>() {
    private val _viewModel by activityViewModels<HomeViewModel>()

    @Inject
    lateinit var adapterImage: AdapterImage

    override fun getViewBinding() = FragmentHomeLayoutBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
        _viewModel.showError = {
            helpers.showToast(it)
        }

        _viewModel.getDataImageHomeRandom { it ->
            it.observe(viewLifecycleOwner, {
                val list = it.map { it.image!! }.toMutableList()
                adapterImage.updateItems(list)
            })
        }
    }

    override fun onInit() {
        initView()
        onClickView()
    }

    private fun onClickView() {
        binding.txtSeeMore.setOnClickListener {
            requireView().navigate(R.id.action_fragmentHome_to_fragmentImageInside)
        }
    }

    private fun initView() {
        binding.lifecycleOwner = this
        binding.title = getString(R.string.lbl_image)

        binding.recyclerHome.apply {
            isNestedScrollingEnabled = false
            layoutManager =
                GridLayoutManager(requireContext(), 3, GridLayoutManager.HORIZONTAL, false)
            adapter = adapterImage
        }
    }
}