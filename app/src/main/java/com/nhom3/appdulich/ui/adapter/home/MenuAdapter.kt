package com.nhom3.appdulich.ui.adapter.home

import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseRecyclerViewAdapter
import com.nhom3.appdulich.data.model.Menu
import com.nhom3.appdulich.databinding.ItemMenuTopBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MenuAdapter @Inject constructor() : BaseRecyclerViewAdapter<Menu, ItemMenuTopBinding>() {

    override fun getLayout() = R.layout.item_menu_top

    override fun onBindViewHolder(holder: BaseViewHolder<ItemMenuTopBinding>, position: Int) {
        holder.binding.menu = items[position]

        holder.binding.root.setOnClickListener {
            listener?.invoke(
                holder.binding.root,
                items[position],
                position
            )
        }
    }
}