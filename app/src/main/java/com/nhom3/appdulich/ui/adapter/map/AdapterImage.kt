package com.nhom3.appdulich.ui.adapter.map

import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseRecyclerViewAdapter
import com.nhom3.appdulich.databinding.ItemArrayImageMapBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdapterImage @Inject constructor() :
    BaseRecyclerViewAdapter<String, ItemArrayImageMapBinding>() {

    override fun getLayout() = R.layout.item_array_image_map

    override fun onBindViewHolder(holder: BaseViewHolder<ItemArrayImageMapBinding>, position: Int) {
        holder.binding.image = items[position]
    }
}