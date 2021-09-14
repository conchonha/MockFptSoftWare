package com.nhom3.appdulich.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nhom3.appdulich.ui.fragment.introduce.FragmentSlide1
import com.nhom3.appdulich.ui.fragment.introduce.FragmentSlide2
import com.nhom3.appdulich.ui.fragment.introduce.FragmentSlide3

class IntroduceAdapter(manager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(manager, lifecycle) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentSlide1()
            1 -> FragmentSlide2()
            2 -> FragmentSlide3()
            else -> throw ClassNotFoundException("ClassNotFoundException")
        }
    }
}