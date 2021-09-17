package com.nhom3.appdulich.ui.fragment.home

import android.os.Bundle
import android.view.View.*
import androidx.core.view.GravityCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.ui.setupWithNavController
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentHomeBinding
import com.nhom3.appdulich.databinding.HeaderHomeBinding
import com.nhom3.appdulich.extension.listener
import com.nhom3.appdulich.extension.navigate
import com.nhom3.appdulich.extension.setUpToolbar
import com.nhom3.appdulich.ui.adapter.home.MenuAdapter
import com.nhom3.appdulich.ui.fragment.bottom_navigation.BottomNavigation
import com.nhom3.appdulich.ui.page.MainActivity
import com.nhom3.appdulich.utils.Const
import com.nhom3.appdulich.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val TAG = "FragmentHome"

@AndroidEntryPoint
class FragmentHome : BaseFragment<FragmentHomeBinding>() {
    private lateinit var _headerHomeBinding: HeaderHomeBinding
    private val _viewModel by activityViewModels<HomeViewModel>()

    @Inject
    lateinit var menuAdapter: MenuAdapter

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
        _viewModel.showError = {
            helpers.showToast(it)
        }

        _viewModel.getAccount(onSuccess = {
            _headerHomeBinding.account = it
        }, onFail = {
            helpers.showAlertDialog(msg = it, context = requireContext()) {
                MainActivity.navController.navigate(R.id.action_bottomNavigation_to_fragmentLogin)
            }
        })

        _viewModel.getMenuTop {
            it.observe(viewLifecycleOwner, {
                menuAdapter.updateItems(it.toMutableList())
            })
        }
    }

    override fun onInit() {
        initView()
        onClickView()
    }

    private fun onClickView() {
        binding.menuDrawable.setOnClickListener {
            binding.drawer.openDrawer(GravityCompat.START)
        }
    }

    private fun initView() {
        //Drawer
        binding.navigationDrawerLayout.apply {
            setupWithNavController(BottomNavigation.navController)

            _headerHomeBinding = HeaderHomeBinding.bind(inflateHeaderView(R.layout.header_home))
            menu.findItem(R.id.logout).setOnMenuItemClickListener {
                _viewModel.logout {
                    MainActivity.navController.navigate(R.id.action_bottomNavigation_to_fragmentLogin)
                }
                return@setOnMenuItemClickListener true
            }
        }

        //appbar layout
        binding.appBarLayout.listener(onSuccess = {
            binding.relativeLayout.visibility = GONE
            binding.toolbar.toolbar.visibility = VISIBLE
        }, onFail = {
            binding.relativeLayout.visibility = VISIBLE
            binding.toolbar.toolbar.visibility = INVISIBLE
        })

        //collapsingToolbarLayout
        binding.collapsingToolbarLayout.apply {
            setExpandedTitleColor(requireContext().getColor(R.color.white))
            setCollapsedTitleTextColor(requireContext().getColor(R.color.white))
        }

        //setIcon toolbar
        binding.toolbar.toolbar.apply {
            setBackgroundColor(context.getColor(R.color.colorPrimary))
            setUpToolbar(R.drawable.ic_menu_24) {
                binding.drawer.openDrawer(GravityCompat.START)
            }
        }

        //recycler
        binding.recyclerviewMenuTop.apply {
            adapter = menuAdapter
            menuAdapter.listener = { view, item, position ->
                requireView().navigate(
                    R.id.action_fragmentHome_to_fragmentIngredient,
                    Bundle().apply {
                        putInt(Const.KEY_ID, item.id!!)
                        putString(Const.KEY_NAME, item.name)
                    })
            }
        }
    }
}
/*
        // private lateinit var _controller: NavController
//        val tesssst = requireParentFragment().childFragmentManager.findFragmentById(R.id.fragmentContainerView2)
//        val navHostFragment = tesssst?.requireParentFragment() as androidx.navigation.fragment.NavHostFragment
//        _controller = navHostFragment.navController
 */