package com.nhom3.appdulich.ui.adapter.home

import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseRecyclerViewAdapter
import com.nhom3.appdulich.data.model.Event
import com.nhom3.appdulich.databinding.ItemLayoutEventBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventAdapter @Inject constructor() :
    BaseRecyclerViewAdapter<Event, ItemLayoutEventBinding>() {
    override fun getLayout() = R.layout.item_layout_event

    override fun onBindViewHolder(holder: BaseViewHolder<ItemLayoutEventBinding>, position: Int) {
        holder.binding.event = items[position]
        holder.binding.root.setOnClickListener {
            listener?.invoke(holder.binding.root, items[position], position)
        }
    }
}