package com.nhom3.appdulich.ui.adapter.home

import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseRecyclerViewAdapter
import com.nhom3.appdulich.data.model.Menu
import com.nhom3.appdulich.databinding.ItemLayoutUtilitiesBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UtilitiesAdapter @Inject constructor() :
    BaseRecyclerViewAdapter<Menu, ItemLayoutUtilitiesBinding>() {

    override fun getLayout() = R.layout.item_layout_utilities

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemLayoutUtilitiesBinding>,
        position: Int
    ) {
        holder.binding.menu = items[position]
        holder.binding.root.setOnClickListener {
            listener?.invoke(holder.binding.root, items[position], position)
        }
    }
}