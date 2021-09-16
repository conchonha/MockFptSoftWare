package com.nhom3.appdulich.ui.adapter.home

import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseRecyclerViewAdapter
import com.nhom3.appdulich.data.model.Place
import com.nhom3.appdulich.databinding.ItemLayoutPlaceBinding

class PlaceAdapterInside :
    BaseRecyclerViewAdapter<Place, ItemLayoutPlaceBinding>() {

    override fun getLayout() = R.layout.item_layout_place

    override fun onBindViewHolder(holder: BaseViewHolder<ItemLayoutPlaceBinding>, position: Int) {
        holder.binding.place = items[position]
        holder.binding.root.setOnClickListener {
            listener?.invoke(holder.binding.root, items[position], position)
        }
    }
}