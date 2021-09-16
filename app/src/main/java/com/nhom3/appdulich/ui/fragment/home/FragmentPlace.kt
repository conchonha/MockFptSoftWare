package com.nhom3.appdulich.ui.fragment.home

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.data.model.Menu
import com.nhom3.appdulich.databinding.FragmentPalceBinding
import com.nhom3.appdulich.ui.adapter.home.PlaceAdapter
import com.nhom3.appdulich.ui.adapter.home.place_body.PlaceAdapterInside
import com.nhom3.appdulich.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentPlace : BaseFragment<FragmentPalceBinding>() {
    private val _viewModel by activityViewModels<HomeViewModel>()

    @Inject
    lateinit var adapterPlace: PlaceAdapter

    override fun getViewBinding() = FragmentPalceBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
        _viewModel.loadingDialog = {
            helpers.showProgressLoading(requireContext())
        }

        _viewModel.showError = {
            helpers.showAlertDialog(msg = it, context = requireContext())
            helpers.dismissProgress()
        }

        _viewModel.getMenuTop {
            adapterPlace.updateItems(it.toMutableList())
            helpers.dismissProgress()
        }
    }

    override fun onInit() {
        initView()
    }

    private fun initView() {
        binding.recyclerPlace.apply {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterPlace

            adapterPlace.listener = { view, item, position ->
                loadDataBody(view as RecyclerView, item, position)
            }
        }
    }

    private fun loadDataBody(recyclerView: RecyclerView, item: Menu, position: Int) {
        val adapterInside = PlaceAdapterInside()

        recyclerView.apply {
            isNestedScrollingEnabled = false
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterInside

            adapterInside.listener = { view, item, position ->

            }
        }

        _viewModel.getDataPlaceHomeRandom(item.id!!, 0) {
            helpers.dismissProgress()
            adapterInside.updateItems(it.toMutableList())
        }
    }

}

//_viewModel.getDataPlaceHomeRandom(item.id!!, 0) {
//    helpers.dismissProgress()
//    adapterPlaceInside.updateItems(it.toMutableList())
//    adapterPlaceInside.listener = { view, item, position ->
//
//    }
//}