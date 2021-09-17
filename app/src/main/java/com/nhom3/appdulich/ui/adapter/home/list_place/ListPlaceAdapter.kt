package com.nhom3.appdulich.ui.adapter.home.list_place

import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseRecyclerViewAdapter
import com.nhom3.appdulich.data.model.Place
import com.nhom3.appdulich.databinding.ItemListPlaceBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListPlaceAdapter @Inject constructor(): BaseRecyclerViewAdapter<Place, ItemListPlaceBinding>() {
    override fun getLayout() = R.layout.item_list_place

    override fun onBindViewHolder(holder: BaseViewHolder<ItemListPlaceBinding>, position: Int) {
        holder.binding.place = items[position]
        holder.binding.root.setOnClickListener {
            listener?.invoke(holder.binding.root, items[position], position)
        }
    }
}