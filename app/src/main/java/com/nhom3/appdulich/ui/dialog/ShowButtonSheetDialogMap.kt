package com.nhom3.appdulich.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nhom3.appdulich.data.model.Place
import com.nhom3.appdulich.databinding.DialogMapBinding
import com.nhom3.appdulich.ui.adapter.map.AdapterImage
import com.nhom3.appdulich.utils.Const

class ShowButtonSheetDialogMap : BottomSheetDialogFragment() {
    private lateinit var _binding: DialogMapBinding
    private val _adapterImage by lazy {  AdapterImage() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogMapBinding.inflate(layoutInflater)
        _binding.lifecycleOwner = this
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.recyclerImage.adapter = _adapterImage
        arguments?.apply {
            val place = getSerializable(Const.KEY_PLACE) as Place?
            place?.let {
                _binding.place = it
                val list = it.arrayImageView?.split("@")
                list?.let { list -> _adapterImage.updateItems(list.toMutableList()) }
            }
        }
    }
}