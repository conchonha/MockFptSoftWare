package com.nhom3.appdulich.ui.fragment.home

import android.view.View.INVISIBLE
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentHomeLayoutBinding
import com.nhom3.appdulich.ui.adapter.home.UtilitiesAdapter
import com.nhom3.appdulich.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentUtilities : BaseFragment<FragmentHomeLayoutBinding>() {
    @Inject
    lateinit var adapterUtilities: UtilitiesAdapter

    private val _viewModel by viewModels<HomeViewModel>()

    override fun getViewBinding() = FragmentHomeLayoutBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
        _viewModel.loadingDialog = {
            helpers.showProgressLoading(requireContext())
        }

        _viewModel.showError = {
            helpers.showAlertDialog(msg = it,context = requireContext())
            helpers.dismissProgress()
        }

        _viewModel.getDataMenuBottom {
            adapterUtilities.updateItems(it.toMutableList())
        }
    }

    override fun onInit() {
        initView()
    }

    private fun initView() {
        binding.recyclerHome.apply {
            layoutManager = GridLayoutManager(requireContext(),2,GridLayoutManager.HORIZONTAL,false)
            adapter = adapterUtilities
        }

        binding.txtSeeMore.visibility = INVISIBLE
        binding.txtTitle.text = getString(R.string.lbl_utilities)
    }
}