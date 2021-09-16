package com.nhom3.appdulich.ui.fragment.home.ingredient

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.data.model.IngredientMenu
import com.nhom3.appdulich.databinding.FragmentIngredientBinding
import com.nhom3.appdulich.extension.listener
import com.nhom3.appdulich.extension.setUpToolbar
import com.nhom3.appdulich.ui.adapter.home.ingredient.IngredientAdapter
import com.nhom3.appdulich.ui.adapter.home.place_body.PlaceAdapterInside
import com.nhom3.appdulich.utils.Const
import com.nhom3.appdulich.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentIngredient : BaseFragment<FragmentIngredientBinding>() {
    private val _viewModel by viewModels<HomeViewModel>()
    private var _id: Int? = null

    @Inject
    lateinit var ingredientAdapter: IngredientAdapter

    override fun getViewBinding() = FragmentIngredientBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
        _viewModel.loadingDialog = {
            helpers.showProgressLoading(requireContext())
        }

        _viewModel.showError = {
            helpers.showAlertDialog(msg = it, context = requireContext())
            helpers.dismissProgress()
        }

        _id?.let {
            _viewModel.getMenuIngredientFromIdMenu(it) { list ->
                helpers.dismissProgress()
                ingredientAdapter.updateItems(list.toMutableList())
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
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ingredientAdapter

            ingredientAdapter.listener = { view, item, position ->
                loadDataBody(view as RecyclerView, item, position)
            }
        }
    }

    private fun loadDataBody(recyclerView: RecyclerView, item: IngredientMenu, position: Int) {
        val adapterInside = PlaceAdapterInside()

        recyclerView.apply {
            isNestedScrollingEnabled = false
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterInside

            adapterInside.listener = { view, item, position ->
                Log.d("AAA", "loadDataBody: $item")
            }
        }

        _viewModel.getDataPlaceHomeRandom(item.id!!, 1) {
            helpers.dismissProgress()
            adapterInside.updateItems(it.toMutableList())
        }
    }
}