package com.nhom3.appdulich.ui.page

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.nhom3.appdulich.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var _navController: NavController
    private lateinit var _navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNavController()
    }

    private fun createNavController() {
        _navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        _navController = _navHostFragment.navController
    }

    fun refreshCurrentFragment() {
        val id = _navController.currentDestination?.id
        _navController.popBackStack(id!!, true)
        _navController.navigate(id)
    }
}