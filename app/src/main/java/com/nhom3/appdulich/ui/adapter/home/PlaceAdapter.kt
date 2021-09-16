package com.nhom3.appdulich.ui.adapter.home

import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseRecyclerViewAdapter
import com.nhom3.appdulich.data.model.Menu
import com.nhom3.appdulich.databinding.FragmentHomeLayoutBinding
import com.nhom3.appdulich.di.MainCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlaceAdapter @Inject constructor(@MainCoroutineScope private val coroutineScope: CoroutineScope) :
    BaseRecyclerViewAdapter<Menu, FragmentHomeLayoutBinding>() {

    override fun getLayout() = R.layout.fragment_home_layout

    override fun onBindViewHolder(
        holder: BaseViewHolder<FragmentHomeLayoutBinding>,
        position: Int
    ) {
        holder.binding.title = items[position].name
        coroutineScope.launch {
            delay(1500)
            listener?.invoke(holder.binding.recyclerHome, items[position], position)
        }
    }
}