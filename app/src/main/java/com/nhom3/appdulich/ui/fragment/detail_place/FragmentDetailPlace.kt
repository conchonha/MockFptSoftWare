package com.nhom3.appdulich.ui.fragment.detail_place

import androidx.fragment.app.viewModels
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentDetailPlaceBinding
import com.nhom3.appdulich.extension.setUpToolbar
import com.nhom3.appdulich.ui.adapter.map.AdapterImage
import com.nhom3.appdulich.utils.Const
import com.nhom3.appdulich.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentDetailPlace : BaseFragment<FragmentDetailPlaceBinding>() {
    private var _id: Int? = null
    private val _viewModel by viewModels<DetailViewModel>()

    @Inject
    lateinit var adapterImage: AdapterImage

    override fun getViewBinding() = FragmentDetailPlaceBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
        _viewModel.loadingDialog = {
            helpers.showProgressLoading(requireContext())
        }

        _viewModel.showError = {
            helpers.dismissProgress()
            helpers.showAlertDialog(msg = it, context = requireContext())
        }

        _id?.let {
            _viewModel.getDataPlaceIdPlace(it) { detailResponse ->
                helpers.dismissProgress()
                detailResponse.data?.let { place ->
                    binding.place = place[0]
                    place[0].arrayImageView?.split("@")?.also {
                        adapterImage.updateItems(it.toMutableList())
                    }
                }
            }
        }
    }

    override fun onInit() {
        binding.lifecycleOwner = this

        arguments?.apply {
            _id = getInt(Const.KEY_ID)
        }

        binding.toolbar.toolbar.setUpToolbar {
            requireActivity().onBackPressed()
        }

        binding.recyclerImage.adapter = adapterImage
    }
}