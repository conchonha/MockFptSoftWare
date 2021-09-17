package com.nhom3.appdulich.ui.adapter.home

import android.view.View
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseRecyclerViewAdapter
import com.nhom3.appdulich.data.model.Menu
import com.nhom3.appdulich.databinding.FragmentHomeLayoutBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlaceAdapter @Inject constructor() :
    BaseRecyclerViewAdapter<Menu, FragmentHomeLayoutBinding>() {
    var seeMoreListener: ((View, Menu, Int)->Unit)? = null

    override fun getLayout() = R.layout.fragment_home_layout

    override fun onBindViewHolder(
        holder: BaseViewHolder<FragmentHomeLayoutBinding>,
        position: Int
    ) {
        holder.binding.title = items[position].name
        holder.binding.txtSeeMore.setOnClickListener {
            seeMoreListener?.invoke(holder.binding.txtSeeMore,items[position],position)
        }
        listener?.invoke(holder.binding.recyclerHome, items[position], position)
    }
}