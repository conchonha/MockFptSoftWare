package com.nhom3.appdulich.ui.adapter.home

import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseRecyclerViewAdapter
import com.nhom3.appdulich.data.model.Place
import com.nhom3.appdulich.databinding.ItemBannerHomeBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BannerAdapter @Inject constructor() :
    BaseRecyclerViewAdapter<Place, ItemBannerHomeBinding>() {

    override fun getItemCount(): Int {
        return if(items.size >= 5) 5 else items.size
    }

    override fun getLayout() = R.layout.item_banner_home

    override fun onBindViewHolder(holder: BaseViewHolder<ItemBannerHomeBinding>, position: Int) {
        holder.binding.image = items[position].image
        holder.binding.root.setOnClickListener {
            listener?.invoke(holder.itemView, items[position], position)
        }
    }
}