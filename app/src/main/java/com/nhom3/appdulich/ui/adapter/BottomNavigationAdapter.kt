package com.nhom3.appdulich.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nhom3.appdulich.ui.fragment.favorite.FragmentFavorite
import com.nhom3.appdulich.ui.fragment.home.FragmentHome
import com.nhom3.appdulich.ui.fragment.search.FragmentSearch
import com.nhom3.appdulich.ui.fragment.setting.FragmentAccount
import com.nhom3.appdulich.ui.page.MainActivity

class BottomNavigationAdapter(manager: FragmentManager, lifecycle: Lifecycle,private  val list : MutableList<Fragment>) :
    FragmentStateAdapter(manager, lifecycle) {

    override fun getItemCount() = list.size

    override fun createFragment(position: Int) = list.get(position)
}