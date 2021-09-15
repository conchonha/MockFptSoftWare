package com.nhom3.appdulich.ui.fragment.home

import androidx.fragment.app.viewModels
import androidx.navigation.ui.setupWithNavController
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentHomeBinding
import com.nhom3.appdulich.databinding.HeaderHomeBinding
import com.nhom3.appdulich.extension.navigate
import com.nhom3.appdulich.ui.page.MainActivity
import com.nhom3.appdulich.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "FragmentHome"

@AndroidEntryPoint
class FragmentHome : BaseFragment<FragmentHomeBinding>() {
    private lateinit var _headerHomeBinding: HeaderHomeBinding
    private val _viewModel by viewModels<HomeViewModel>()

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
        _viewModel.getAccount(onSuccess = {
            _headerHomeBinding.account = it
        }, onFail = {
            helpers.showAlertDialog(msg = it, context = requireContext()) {
                MainActivity.navController.navigate(R.id.action_bottomNavigation_to_fragmentLogin)
            }
        })
    }

    override fun onInit() {
        initView()
    }

    private fun initView() {
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
    }
}
/*
        // private lateinit var _controller: NavController
//        val tesssst = requireParentFragment().childFragmentManager.findFragmentById(R.id.fragmentContainerView2)
//        val navHostFragment = tesssst?.requireParentFragment() as androidx.navigation.fragment.NavHostFragment
//        _controller = navHostFragment.navController
 */