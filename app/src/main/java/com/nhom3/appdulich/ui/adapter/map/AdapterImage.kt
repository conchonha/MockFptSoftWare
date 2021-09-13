package com.nhom3.appdulich.ui.adapter.map

import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseRecyclerViewAdapter
import com.nhom3.appdulich.databinding.ItemArrayImageMapBinding

class AdapterImage : BaseRecyclerViewAdapter<String, ItemArrayImageMapBinding>() {
    override fun getLayout() = R.layout.item_array_image_map

    override fun onBindViewHolder(holder: BaseViewHolder<ItemArrayImageMapBinding>, position: Int) {
        holder.binding.image = items[position]
    }
}