package com.nhom3.appdulich.ui.fragment.home

import android.os.Bundle
import android.view.View.INVISIBLE
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentHomeLayoutBinding
import com.nhom3.appdulich.extension.navigate
import com.nhom3.appdulich.ui.adapter.home.UtilitiesAdapter
import com.nhom3.appdulich.utils.Const
import com.nhom3.appdulich.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentUtilities : BaseFragment<FragmentHomeLayoutBinding>() {
    private val _viewModel by activityViewModels<HomeViewModel>()

    @Inject
    lateinit var adapterUtilities: UtilitiesAdapter

    override fun getViewBinding() = FragmentHomeLayoutBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
        _viewModel.showError = {
            helpers.showToast(it)
        }

        _viewModel.getDataMenuBottom {
            it.observe(viewLifecycleOwner, {
                adapterUtilities.updateItems(it.toMutableList())
            })
        }
    }

    override fun onInit() {
        initView()
    }

    private fun initView() {
        binding.lifecycleOwner = this
        binding.title = getString(R.string.lbl_utilities)

        binding.recyclerHome.apply {
            layoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.HORIZONTAL, false)
            adapter = adapterUtilities
            isNestedScrollingEnabled = false

            adapterUtilities.listener = { view, item, position ->
                requireView().navigate(
                    R.id.action_fragmentHome_to_fragmentIngredient,
                    Bundle().apply {
                        putInt(Const.KEY_ID, item.id!!)
                        putString(Const.KEY_NAME, item.name)
                    })
            }
        }

        binding.txtSeeMore.visibility = INVISIBLE
    }
}