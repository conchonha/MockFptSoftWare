package com.nhom3.appdulich.ui.fragment.favorite

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nhom3.appdulich.R
import com.nhom3.appdulich.databinding.FragmentFavoriteBinding
import com.nhom3.appdulich.ui.adapter.favorite.FavoritePlaceAdapter
import com.nhom3.appdulich.viewmodel.FavoritePlaceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentFavorite : Fragment(R.layout.fragment_favorite) {
    private val viewModel: FavoritePlaceViewModel by viewModels()
    private lateinit var binding: FragmentFavoriteBinding
    private val adapter = FavoritePlaceAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        binding.rvFavoritePlace.adapter = adapter
        getPlaceFromDB()
        eventSearch()

        return binding.root
    }

    private fun eventSearch() {
        binding.edSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.edSearch.text.toString().let {
                    getDataSearch(it)
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })
    }

    private fun getDataSearch(namePlace: String) {
        viewModel.searchPlace(namePlace).observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    private fun getPlaceFromDB() {
        viewModel.getAllPlace().observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }
}