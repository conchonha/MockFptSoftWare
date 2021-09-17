package com.nhom3.appdulich.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.data.model.Menu
import com.nhom3.appdulich.databinding.FragmentPalceBinding
import com.nhom3.appdulich.extension.navigate
import com.nhom3.appdulich.ui.adapter.home.PlaceAdapter
import com.nhom3.appdulich.ui.adapter.home.place_body.PlaceAdapterInside
import com.nhom3.appdulich.utils.Const
import com.nhom3.appdulich.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FragmentPlace : BaseFragment<FragmentPalceBinding>() {
    private val _viewModel by activityViewModels<HomeViewModel>()

    @Inject
    lateinit var adapterPlace: PlaceAdapter

    override fun getViewBinding() = FragmentPalceBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
        _viewModel.showError = {
            helpers.showToast(it)
        }

        _viewModel.getMenuTop {
            it.observe(viewLifecycleOwner, {
                adapterPlace.updateItems(it.toMutableList())
            })
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
                lifecycleScope.launch {
                    delay(2000)
                    loadDataBody(view as RecyclerView, item, position)
                }
            }
            adapterPlace.seeMoreListener = { view, menu, i ->
                requireView().navigate(
                    R.id.action_fragmentHome_to_fragmentIngredient,
                    Bundle().apply {
                        putInt(Const.KEY_ID, menu.id!!)
                        putString(Const.KEY_NAME, menu.name)
                    })
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
                requireView().navigate(R.id.action_global_fragmentDetailPlace, Bundle().apply {
                    putInt(Const.KEY_ID, item.id)
                })
            }
        }

        _viewModel.getDataPlaceHomeRandom(item.id!!, 0) {
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