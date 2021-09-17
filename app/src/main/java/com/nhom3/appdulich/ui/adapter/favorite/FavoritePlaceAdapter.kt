package com.nhom3.appdulich.ui.adapter.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nhom3.appdulich.core.room.FavoritePlace
import com.nhom3.appdulich.databinding.ItemFavoritePlaceBinding

val diffCallback =object : DiffUtil.ItemCallback<FavoritePlace>() {
    override fun areItemsTheSame(oldItem: FavoritePlace, newItem: FavoritePlace): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FavoritePlace, newItem: FavoritePlace): Boolean {
        return oldItem == newItem
    }

}
class FavoritePlaceAdapter: ListAdapter<FavoritePlace, FavoritePlaceAdapter.ViewHolder>(diffCallback) {
    var listener: ((FavoritePlace)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFavoritePlaceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            listener?.invoke(getItem(position))
        }
    }

    class ViewHolder(private val binding: ItemFavoritePlaceBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(place: FavoritePlace) {
            binding.favoritePlace = place
            binding.executePendingBindings()

        }
    }
}