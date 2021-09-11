package com.nhom3.appdulich.ui.fragment.home

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nhom3.appdulich.R
import com.nhom3.appdulich.data.model.Place
import com.nhom3.appdulich.databinding.FragmentBannerBinding
import kotlinx.coroutines.*
import java.lang.Runnable
import java.util.ArrayList

class Banner_Fragment : Fragment(R.layout.fragment_banner) {

    private lateinit var binding: FragmentBannerBinding
    val job = Job

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBannerBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root

        autoSlideViewPager()
        init()
    }

    private fun autoSlideViewPager() {
//       val handler = Handler()
//        val runnable = Runnable {
//            var mCurrenItem = binding.vpBannerMain.getCurrentItem()
//            mCurrenItem++
//            if (mCurrenItem >= binding.vpBannerMain.getAdapter()!!.getCount()) {
//                mCurrenItem = 0
//            }
//            binding.vpBannerMain.setCurrentItem(mCurrenItem, true)
//            handler.postDelayed(runnable, 4500)
//        }
//        handler.postDelayed(runnable, 4500)

        CoroutineScope(Dispatchers.IO ).launch {
            var mCurrenItem = binding.vpBannerMain.getCurrentItem()
            mCurrenItem++
            if (mCurrenItem >= binding.vpBannerMain.getAdapter()!!.getCount()) {
                mCurrenItem = 0
            }
            binding.vpBannerMain.setCurrentItem(mCurrenItem, true)
            delay(5000)
        }
    }

    private fun init() {
        val arrayList: ArrayList<Place> = ArrayList<Place>()



    }
}