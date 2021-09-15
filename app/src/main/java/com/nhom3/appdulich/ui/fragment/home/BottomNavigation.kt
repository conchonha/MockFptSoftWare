package com.nhom3.appdulich.ui.fragment.home

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentBottomNavigationBinding
import com.nhom3.appdulich.extension.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomNavigation : BaseFragment<FragmentBottomNavigationBinding>() {
    private lateinit var _navHostFragment: NavHostFragment

    companion object {
        lateinit var navController: NavController
    }

    override fun getViewBinding() = FragmentBottomNavigationBinding.inflate(layoutInflater)

    override fun listenerViewModel() {

    }

    override fun onInit() {
        createNavController()
        initView()
        onClickView()
    }

    private fun onClickView() {
        binding.fab.setOnClickListener {
            navController.navigate(R.id.action_global_fragmentMap)
        }
    }

    private fun createNavController() {
        _navHostFragment =
            childFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        navController = _navHostFragment.navController
    }

    private fun initView() {
        binding.bottomNavigate.apply {
            setupWithNavController(navController)
            background = null
        }
    }
}