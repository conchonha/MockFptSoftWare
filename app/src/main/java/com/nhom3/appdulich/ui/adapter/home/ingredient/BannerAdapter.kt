package com.nhom3.appdulich.ui.adapter.home.ingredient

import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseRecyclerViewAdapter
import com.nhom3.appdulich.data.model.Place
import com.nhom3.appdulich.databinding.ItemBannerIngredientBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BannerAdapter @Inject constructor() :
    BaseRecyclerViewAdapter<Place, ItemBannerIngredientBinding>() {

    override fun getItemCount(): Int {
        return if (items.size >= 5) 5 else items.size
    }

    override fun getLayout() = R.layout.item_banner_ingredient

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemBannerIngredientBinding>,
        position: Int
    ) {
        holder.binding.place = items[position]
        holder.binding.root.setOnClickListener {
            listener?.invoke(holder.itemView, items[position], position)
        }
    }
}