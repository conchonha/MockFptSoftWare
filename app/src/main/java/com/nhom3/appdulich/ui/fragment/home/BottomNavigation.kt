package com.nhom3.appdulich.ui.fragment.home

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentBottomNavigationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomNavigation : BaseFragment<FragmentBottomNavigationBinding>() {
    private lateinit var _navHostFragment: NavHostFragment
    lateinit var navController: NavController

    override fun getViewBinding() = FragmentBottomNavigationBinding.inflate(layoutInflater)

    override fun listenerViewModel() {

    }

    override fun onInit() {
        createNavController()
        initView()
    }

    private fun createNavController() {
        _navHostFragment =
            childFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        navController = _navHostFragment.navController
    }

    private fun initView() {
        binding.bottomNavigate.setupWithNavController(navController)
    }
}