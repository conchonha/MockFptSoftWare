package com.nhom3.appdulich.ui.adapter.home

import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseRecyclerViewAdapter
import com.nhom3.appdulich.data.model.Menu
import com.nhom3.appdulich.databinding.FragmentHomeLayoutBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlaceAdapter @Inject constructor() :
    BaseRecyclerViewAdapter<Menu, FragmentHomeLayoutBinding>() {

    override fun getLayout() = R.layout.fragment_home_layout

    override fun onBindViewHolder(
        holder: BaseViewHolder<FragmentHomeLayoutBinding>,
        position: Int
    ) {
        holder.binding.title = items[position].name
        listener?.invoke(holder.binding.recyclerHome, items[position], position)
    }
}